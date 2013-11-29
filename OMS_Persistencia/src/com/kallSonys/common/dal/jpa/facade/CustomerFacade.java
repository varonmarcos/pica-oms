/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kallSonys.common.dal.jpa.facade;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import oracle.jdbc.OracleTypes;

import com.kallSonys.common.dal.conectionjdbc.JBDConnection;
import com.kallSonys.common.dal.jpa.entitys.Customer;

/**
 *
 * @author Frank
 */
@Stateless(name="CustomerFacadeBean", mappedName = "CustomerFacadeBean")
@Remote(CustomerFacadeLocal.class)
public class CustomerFacade extends AbstractFacade<Customer> implements CustomerFacadeLocal {
	@PersistenceContext(unitName = "OMS_Persistencia")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CustomerFacade() {
        super(Customer.class);
    }   

    public  String createAndReturnID(Customer customer)
    {
    	
    	 try
         {
             getEntityManager().persist(customer);  
             getEntityManager().flush(); 
             String id = customer.getCustid(); 
             System.out.println("ID CUSTOMER CREADO: "+id);
             return id;
         }
         catch(Exception e)
         {
         	System.out.println("ERROR:CustomerFacade:createAndReturnID: "+e.getMessage());
         	return null;
         }
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> getCustomersByProduct(String idProduct) {
		
		 List<Customer> listCustomers=new ArrayList<Customer>();
		 Connection dbConnection = null;
		 try{
			
			 CallableStatement callableStatement = null;
			 String returnCustomer = "{call GETCUSTOMERS_BY_IDPRODUCT(?,?)}";
			 dbConnection = JBDConnection.getDBConnection();
			 callableStatement = dbConnection.prepareCall(returnCustomer);
			 callableStatement.setString(1, idProduct);
			 callableStatement.registerOutParameter(2,OracleTypes.CURSOR);
			 callableStatement.executeUpdate();
			 ResultSet rs = (ResultSet) callableStatement.getObject(2);
			 System.out.println(rs);
			 while (rs.next()) {
				 	Customer cus=new Customer();
				 	cus.setCustid(rs.getString("CUSTID"));
				 	cus.setFname(rs.getString("FNAME"));
				 	cus.setPhonenumber(rs.getString("PHONENUMBER"));
				 	cus.setEmail(rs.getString("EMAIL"));
				 	cus.setCreditcardtype(rs.getString("CREDITCARDTYPE"));
				 	cus.setCreditcardnumer(rs.getString("CREDITCARDNUMER"));
				 	cus.setStatus(rs.getString("STATUS"));
					listCustomers.add(cus); 
					
				}
		 }catch (Exception e) {
			e.printStackTrace();
		}finally{
			JBDConnection.closeDBConnection(dbConnection);
		}
			
		return listCustomers;
	}

	@Override
	public List<Customer> getCustomersByFechas(java.sql.Date dateIn,java.sql.Date dateFin) {
		List<Customer> listCustomers=new ArrayList<Customer>();
		 Connection dbConnection = null;
		 try{
			
			 CallableStatement callableStatement = null;
			 String returnCustomer = "{call GET_CUSTOMER_BY_PRICE(?,?,?)}";
			 dbConnection = JBDConnection.getDBConnection();
			 callableStatement = dbConnection.prepareCall(returnCustomer);
			 callableStatement.setDate(1,dateIn);
			 callableStatement.setDate(2,dateFin);
			 callableStatement.registerOutParameter(3, OracleTypes.CURSOR);
			 callableStatement.executeUpdate();
			 ResultSet rs = (ResultSet) callableStatement.getObject(3);
			 System.out.println(rs);
			 while (rs.next()) {
				 	Customer cus=new Customer();
				 	cus.setCustid(rs.getString("CUSTID"));
				 	cus.setFname(rs.getString("FNAME"));
				 	cus.setPhonenumber(rs.getString("PHONENUMBER"));
				 	cus.setEmail(rs.getString("EMAIL"));
				 	cus.setCreditcardtype(rs.getString("CREDITCARDTYPE"));
				 	cus.setCreditcardnumer(rs.getString("CREDITCARDNUMER"));
				 	cus.setPrice(rs.getString("PRICE"));
				 	cus.setStatus(rs.getString("STATUS"));
					listCustomers.add(cus); 
					
				}
		 }catch (Exception e) {
			e.printStackTrace();
		}finally{
			JBDConnection.closeDBConnection(dbConnection);
		}
			
		return listCustomers;
	}
	   
}
