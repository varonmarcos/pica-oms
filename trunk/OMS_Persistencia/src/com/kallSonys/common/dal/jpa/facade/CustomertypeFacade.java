/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kallSonys.common.dal.jpa.facade;

import com.kallSonys.common.dal.jpa.entitys.Customertype;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Frank
 */
@Stateless(name="CustomertypeFacadeBean", mappedName = "CustomertypeFacadeBean")
@Remote(CustomertypeFacadeLocal.class)
public class CustomertypeFacade extends AbstractFacade<Customertype> implements CustomertypeFacadeLocal {
	@PersistenceContext(unitName = "OMS_Persistencia")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CustomertypeFacade() {
        super(Customertype.class);
    }

    @Override
    public boolean createAndConfirm(Customertype entity) 
    {
      try
        {
            getEntityManager().persist(entity);            
        }catch(Exception e){return false;}
        
        return true;
    }
    
}
