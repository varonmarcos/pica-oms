/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kallSonys.common.dal.jpa.facade;

import com.kallSonys.common.dal.jpa.entitys.Items;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Frank
 */
@Stateless(name="ItemsFacadeBean", mappedName = "ItemsFacadeBean")
@Remote(ItemsFacadeLocal.class)
public class ItemsFacade extends AbstractFacade<Items> implements ItemsFacadeLocal {
    @PersistenceContext(unitName = "common.dalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ItemsFacade() {
        super(Items.class);
    }

    @Override
    public boolean createAndConfirm(Items entity) 
    {
        try
        {
            getEntityManager().persist(entity);            
        }catch(Exception e){return false;}
        
        return true;
    }
    
}
