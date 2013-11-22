/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kallSonys.common.dal.jpa.facade;

import java.util.List;

import com.kallSonys.common.dal.jpa.entitys.Address;
import com.kallSonys.common.dal.jpa.entitys.Customer;
import com.kallSonys.common.dal.jpa.entitys.Orders;

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
}
