/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kallSonys.common.dal.jpa.facade;

import com.kallSonys.common.dal.jpa.entitys.Address;
import com.kallSonys.common.dal.jpa.entitys.CustomerAddress;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Frank
 */
@Stateless(name="CustomerAddressBean", mappedName = "CustomerAddressBean")
@Remote(CustomerAddressFacadeLocal.class)
public class CustomerAddressFacade extends AbstractFacade<CustomerAddress> implements CustomerAddressFacadeLocal {
    @PersistenceContext(unitName = "common.dalPU")
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
        }catch(Exception e){return false;}
        
        return true;
    }
    
        
}
