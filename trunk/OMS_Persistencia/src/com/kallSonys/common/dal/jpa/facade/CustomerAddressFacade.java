/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kallSonys.common.dal.jpa.facade;

import java.util.ArrayList;
import java.util.List;

import com.kallSonys.common.dal.jpa.entitys.AppRecurso;
import com.kallSonys.common.dal.jpa.entitys.CustomerAddress;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Frank
 */
@Stateless(name="CustomerAddressBean", mappedName = "CustomerAddressBean")
@Remote(CustomerAddressFacadeLocal.class)
public class CustomerAddressFacade extends AbstractFacade<CustomerAddress> implements CustomerAddressFacadeLocal {
	@PersistenceContext(unitName = "OMS_Persistencia")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CustomerAddressFacade() {
        super(CustomerAddress.class);
    }

    @Override
    public boolean createAndConfirm(CustomerAddress entity) 
    {
         try
        {
            getEntityManager().persist(entity);
            getEntityManager().flush();
        }catch(Exception e)
        {
        	System.out.println("Error CustomerAddress.createAndConfirm: "+e.getMessage());
        	return false;
        }
        
        return true;
    }
   

    public boolean createAndConfirmNative(CustomerAddress customerAddress) 
    {
        try
        {        	    
		   String sqlNativo = "INSERT INTO CUSTOMER_ADDRESS "+
                              " VALUES (SEQ_CUSTOMER_ADDRESS.NEXTVAL,'"+customerAddress.getCustomer().getCustid()+"','"+customerAddress.getAddress().getAddrid()+"')";	
		   

		   	System.out.println("sqlNativo: "+sqlNativo);
		   
		    Query query = em.createNativeQuery(sqlNativo);
		    if(query.executeUpdate()>0)
		    {
		    	return true;
		    }
        	 
        }catch(Exception e)
        {
        	System.out.println("Error CustomerAddress.createAndConfirm: "+e.getMessage());
        	return false;
        }
        
        return false;
    }
    
        
}
