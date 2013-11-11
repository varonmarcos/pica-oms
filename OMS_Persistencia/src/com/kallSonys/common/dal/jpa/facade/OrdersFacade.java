/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kallSonys.common.dal.jpa.facade;

import com.kallSonys.common.dal.jpa.entitys.Orders;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

    @Override
    public boolean createAndConfirm(Orders entity) 
    {
          try
        {
            getEntityManager().persist(entity);            
        }catch(Exception e){return false;}
        
        return true;
    }
    
}
