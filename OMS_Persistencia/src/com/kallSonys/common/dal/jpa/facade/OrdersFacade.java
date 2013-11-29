/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kallSonys.common.dal.jpa.facade;

import java.math.BigDecimal;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.kallSonys.common.dal.jpa.entitys.AppRecurso;
import com.kallSonys.common.dal.jpa.entitys.Customer;
import com.kallSonys.common.dal.jpa.entitys.Item;
import com.kallSonys.common.dal.jpa.entitys.Orders;
import com.kallSonys.common.dal.util.Utils;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Frank
 */
@Stateless(name="OrdersFacadeBean", mappedName = "OrdersFacadeBean")
@Remote(OrdersFacadeLocal.class)
public class OrdersFacade extends AbstractFacade<Orders> implements OrdersFacadeLocal {
	@PersistenceContext(unitName = "OMS_Persistencia")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrdersFacade() {
        super(Orders.class);
    }

    
    /*Crea una orden y devuelve el ID generado para la misma*/
    public  String createAndReturnID(Orders orders)
    {
    	 //Manejamos una sola transaccion
		 //EntityTransaction tx = getEntityManager().getTransaction();
		 //tx.begin();
		 boolean txOK = true;
    	 
		 try
         {    		
    		 //Se crea la orden 
    		 String nextIdOrden = this.getNextOrderID();
    		 String sqlNativo ="Insert into ORDERS (CUSTID,ORDERID,ORDERDATE,PRICE,STATUS,COMMENTS) "+
    		                   " values (?1,?2,SYSDATE,?3,?4,?5)";
    		 
    		System.out.println("sqlNativo ORDENES: "+sqlNativo);
    		Query query = em.createNativeQuery(sqlNativo);
    		query.setParameter(1, orders.getCustomer().getCustid());
    		query.setParameter(2,nextIdOrden);    		
    		query.setParameter(3, orders.getPrice());    		
    		query.setParameter(4, orders.getStatus());
    		
    		if(orders.getComments()!=null)
    		{
    			query.setParameter(5, orders.getComments());
    		}
    		else
    		{
    			query.setParameter(5, null);
    		}
    		
 		    if(query.executeUpdate()>0)
 		    { 		    	 		    	 		    	 		  
 		    	//Creamos los items de la orden
 		    	String nextIdItem; 
 		    	Set<Item> setProductos = orders.getItems(); 	            
 	            ItemsFacade itemFacade = new  ItemsFacade();
 	            for(Item producto : setProductos)
 	            {
 	            	 nextIdItem = this.getNextItemID();
 	            	 System.out.println("NEXT ID ITEM: "+nextIdItem);
 	              	 sqlNativo ="Insert into ITEMS (ITEMID,PRODID,PRODUCTNAME,PARTNUM,PRICE,QUANTITY,ORDERID) "+
		 	              			" values (SEQ_ITEMS.NEXTVAL,?1,?2,?3,?4,?5,?6)";		
		 	              			               			 		                          		    	 	               
 	              	System.out.println("sqlNativo ITEMS: "+sqlNativo);
 	              	query = em.createNativeQuery(sqlNativo);
 	              	//query.setParameter(1, nextIdItem);
	 	       		query.setParameter(1, producto.getProdid());    		
	 	       		query.setParameter(2, producto.getProductname());
	 	       		query.setParameter(3, producto.getPartnum());
	 	       		query.setParameter(4, producto.getPrice());
	 	       		query.setParameter(5, producto.getQuantity());
	 	       		query.setParameter(6, nextIdOrden);
 	              		 	       		
 	              	if(query.executeUpdate() <= 0)
 	    		    { 
 	              		txOK = false;
 	              		break;
 	    		    }
 	             }
 		    }
 		    else
 		    {
 		    	txOK = false;
 		    }
 		    
 		    //verificamos que la TX es OK para hacer commit
 		    if(txOK)
 		    {
 		    	//tx.commit(); 		    	
 		    	return nextIdOrden;
 		    }
    		     		
             return "-1";
         }
         catch(Exception e)
         {
         	System.out.println("====== ERROR EN:OrdersFacade.createAndReturnID: "+e.getMessage());
         	System.out.println("====== TRAZA DEL ERROR: ");
         	e.printStackTrace();
         	System.out.println("========================");
         	/*
         	if(tx.isActive())
         	{
         		tx.rollback();
         		tx = null;
         	}
         	*/
         	return "-1";
         }
    }
    
    public List<Orders> getOrderByCustomer (String customerID)
    {
        	     	
    	 if(customerID != null && customerID.length()>0)
		 {
			 		 		
	        //Objeto a devolver
	        List<Orders> setListOrders = new ArrayList<Orders>();
	         
	        String sqlNativo = "SELECT CUSTID,ORDERID,ORDERDATE,PRICE,STATUS,COMMENTS "+
	        					" FROM orders WHERE custid = '"+customerID+"' ORDER BY ORDERID ASC";
	                	        
	        Query query = em.createNativeQuery(sqlNativo);
	        
	        @SuppressWarnings("unchecked")
			List<Object[]> listado = query.getResultList();         
	        if(listado !=null && !listado.isEmpty())
	        {
	            for (Iterator<Object[]> it = listado.iterator(); it.hasNext();) 
	            {
	                Object[] resultElement = it.next();
	                
	                Orders order = new  Orders();
	                Customer customer = new Customer();
	                customer.setCustid(customerID);
	                order.setCustomer(customer);
	                order.setOrderid(resultElement[1].toString().trim());
	                order.setOrderdate(Utils.getStringToCalendar(resultElement[2].toString().trim(), "yyyy-MM-dd").getTime());	                 
	                order.setPrice(new BigDecimal(resultElement[3].toString().trim()));
	                order.setStatus(resultElement[4].toString().trim());
	                if(resultElement[5]!=null)
	                {
	                	order.setComments(resultElement[5].toString().trim());	
	                }
	                else
	                {
	                	order.setComments("");
	                }	                
	                setListOrders.add(order);	                
	            }                                                
	        }
	                        
	        return setListOrders;
		 }		 	
    	return null;
    }
    
    
    public String actualizarEstadoOrden(String idOrden, String nuevoEstado)
    {
    	String result="ERROR";
    	System.out.println("OrderFacede actualizarEstadoOrden 1: "+idOrden+"-"+nuevoEstado);
    	   String sqlNativo = "UPDATE orders "+
					" SET status = '"+ nuevoEstado.toUpperCase() +"' "+
					" WHERE orderid = '"+ idOrden +"' ";       	        
    	   try
    	   {
    			Query query = em.createNativeQuery(sqlNativo);
    			int resultUpdate = query.executeUpdate();
    			System.out.println("OrderFacede actualizarEstadoOrden 2: "+resultUpdate);
        	   	if(resultUpdate>0)
        	   	{
        	   		result = "OK";
        	   	}        	           	   
    	   }
    	   catch (Exception e)
    	   {    		 
    		   System.out.println("====== ERROR EN:OrdersFacade.actualizarEstadoOrden: "+e.getMessage());
               System.out.println("====== TRAZA DEL ERROR: ");
               e.printStackTrace();
               System.out.println("========================");    		   
    	   }
    	   System.out.println("OrderFacede actualizarEstadoOrden 3: "+result);
    	   return result;                                                   	
    	
    }
    
    
    public List<Orders> getDetallesOrder (String orderID)
    {
    
    	//Objeto a devolver
        List<Orders> setListOrders = new ArrayList<Orders>();
        Set<Item> setListProductos = new HashSet<Item>();;
        boolean loadOrder=false;
        
    	String SQLnativo = "SELECT "+ 
							"	ORD.ORDERID, "+
							"	ORD.ORDERDATE, "+
							"	ORD.PRICE AS VALOR_TOTAL, "+
							"	ORD.STATUS AS ESTADO, "+
							"	ORD.COMMENTS, "+
							"	ITS.PRODID, "+
							"	ITS.PRODUCTNAME AS PRODUCTO, "+
							"	ITS.QUANTITY AS CANTIDAD, "+
							"	ITS.PRICE VALORUND, "+
							"	ITS.PRICE*ITS.QUANTITY AS SUBTOTAL "+
							"	FROM ORDERS ORD "+
							"	INNER JOIN ITEMS ITS ON ORD.ORDERID = ITS.ORDERID "+
							"	WHERE ORD.ORDERID = "+orderID;
    	    	
		    	try
		    	{
		    		Query query = em.createNativeQuery(SQLnativo);
		    		@SuppressWarnings("unchecked")
					List<Object[]> listado = query.getResultList();         
			        if(listado !=null && !listado.isEmpty())
			        {
			            for (Iterator<Object[]> it = listado.iterator(); it.hasNext();) 
			            {
			                Object[] resultElement = it.next();
			                //cargando encabezado de la orden
			                if(!loadOrder)
			                {
			                	Orders order = new  Orders();	                
				                order.setOrderid(resultElement[0].toString().trim());	              
				                order.setOrderdate(Utils.getStringToCalendar(resultElement[1].toString().trim(), "yyyy-MM-dd").getTime());	                	               
				                order.setPrice(new BigDecimal(resultElement[2].toString().trim()));	                	               
				                order.setStatus(resultElement[3].toString().trim());	                
				                if(resultElement[4]!=null)
				                {
				                	order.setComments(resultElement[4].toString().trim());	
				                }
				                else
				                {
				                	order.setComments("");
				                }	   	                
				                setListOrders.add(order);
				                loadOrder=true;
			                }
			                //cargarndo productos de la orden
			                Item producto = new Item();
			                producto.setProdid(new BigDecimal (resultElement[5].toString().trim()));
			                producto.setProductname(resultElement[6].toString().trim());
			                producto.setQuantity(new BigDecimal(resultElement[7].toString().trim()));
			                producto.setPrice(new BigDecimal(resultElement[8].toString().trim()));	                
			                setListProductos.add(producto);
			            }   
			            setListOrders.get(0).setItems(setListProductos);
			        }
		    	}
		    	catch(Exception e)
		    	{
	    		   System.out.println("====== ERROR EN:OrdersFacade.getDetallesOrder: "+e.getMessage());
	               System.out.println("====== TRAZA DEL ERROR: ");
	               e.printStackTrace();
	               System.out.println("========================");
		    		return null;
		    	}    			                       
	        return setListOrders;	    	    	
    }
    
    //retorna el proximo ID para una orden
    private String getNextOrderID()
    {
    	String sqlNextID = "SELECT SEQ_ORDERS.NEXTVAL FROM DUAL";
    	Query query = em.createNativeQuery(sqlNextID);
    	BigDecimal value = new BigDecimal(query.getSingleResult().toString());    	
    	 return value.toString();
    }
  //retorna el proximo ID para insertar un item
    private String getNextItemID()
    {
    	String sqlNextID = "SELECT SEQ_ITEMS.NEXTVAL FROM DUAL";
    	Query query = em.createNativeQuery(sqlNextID);
    	BigDecimal value = new BigDecimal(query.getSingleResult().toString());    	
   	    return value.toString();    	    	    	  
    }
}
