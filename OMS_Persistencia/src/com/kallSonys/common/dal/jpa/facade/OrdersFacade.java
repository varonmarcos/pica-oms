/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kallSonys.common.dal.jpa.facade;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.kallSonys.common.dal.jpa.entitys.AppRecurso;
import com.kallSonys.common.dal.jpa.entitys.Customer;
import com.kallSonys.common.dal.jpa.entitys.Orders;
import com.kallSonys.common.dal.util.Utils;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
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
    	
    	 try
         {
             getEntityManager().persist(orders);  
             getEntityManager().flush(); 
             String id = orders.getOrderid();
             System.out.println("ID DE ORDEN CREADO: "+id);
             return id;
         }
         catch(Exception e)
         {
         	System.out.println("ERROR:OrdersFacade:createAndReturnID: "+e.getMessage());
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
	        					" FROM orders WHERE custid = "+customerID;
	                	        
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
    
}
