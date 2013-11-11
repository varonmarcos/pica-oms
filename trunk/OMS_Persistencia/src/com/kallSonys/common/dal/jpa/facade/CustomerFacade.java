/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kallSonys.common.dal.jpa.facade;

import com.kallSonys.common.dal.jpa.entitys.Customer;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Frank
 */
@Stateless(name="CustomerFacadeBean", mappedName = "CustomerFacadeBean")
@Remote(CustomerFacadeLocal.class)
public class CustomerFacade extends AbstractFacade<Customer> implements CustomerFacadeLocal {
    @PersistenceContext(unitName = "common.dalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CustomerFacade() {
        super(Customer.class);
    }

    @Override
    public boolean createAndConfirm(Customer entity) 
    {
          try
        {
            getEntityManager().persist(entity);            
        }catch(Exception e){return false;}
        
        return true;
    }
    
}
