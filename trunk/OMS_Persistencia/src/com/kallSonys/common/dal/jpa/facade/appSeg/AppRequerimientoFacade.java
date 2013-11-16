package com.kallSonys.common.dal.jpa.facade.appSeg;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.kallSonys.common.dal.jpa.entitys.AppRequerimiento;
import com.kallSonys.common.dal.jpa.facade.AbstractFacade;


/**
 * @generated DT_ID=none
 */
@Stateless(name = "AppRequerimientoBean", mappedName = "AppRequerimientoBean")
public class AppRequerimientoFacade extends AbstractFacade<AppRequerimiento> implements  AppRequerimientoFacadeRemote {
	 @PersistenceContext(unitName = "OMS_Persistencia")
	 private EntityManager em;
	
	
	 @Override
	    protected EntityManager getEntityManager() {
	        return em;
	    }
	
	 public AppRequerimientoFacade() {
	        super(AppRequerimiento.class);
	    }	

}
