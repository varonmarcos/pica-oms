package com.kallSonys.common.dal.jpa.facade.appSeg;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.kallSonys.common.dal.jpa.entitys.AppRol;
import com.kallSonys.common.dal.jpa.facade.AbstractFacade;


/**
 * @generated DT_ID=none
 */
@Stateless(name = "AppRolBean", mappedName = "AppRolBean")
public class AppRolFacade extends AbstractFacade<AppRol> implements  AppRolFacadeRemote {

	 @PersistenceContext(unitName = "OMS_Persistencia")
	 private EntityManager em;
	
	
	 @Override
	    protected EntityManager getEntityManager() {
	        return em;
	    }
	
	 public AppRolFacade() {
	        super(AppRol.class);
	    }
}
