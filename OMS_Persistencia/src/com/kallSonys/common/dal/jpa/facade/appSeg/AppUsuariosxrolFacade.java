package com.kallSonys.common.dal.jpa.facade.appSeg;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.kallSonys.common.dal.jpa.entitys.AppUsuariosxrol;
import com.kallSonys.common.dal.jpa.facade.AbstractFacade;


/**
 * @generated DT_ID=none
 */
@Stateless(name = "AppUsuariosxrolBean", mappedName = "AppUsuariosxrolBean")
public class AppUsuariosxrolFacade extends AbstractFacade<AppUsuariosxrol> implements AppUsuariosxrolFacadeRemote
{
	
	 @PersistenceContext(unitName = "OMS_Persistencia")
	 private EntityManager em;
	
	
	 @Override
	    protected EntityManager getEntityManager() {
	        return em;
	    }
	
	 public AppUsuariosxrolFacade() {
	        super(AppUsuariosxrol.class);
	    }
}
