package com.kallSonys.common.dal.jpa.facade.appSeg;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.kallSonys.common.dal.jpa.entitys.AppRecurso;
import com.kallSonys.common.dal.jpa.facade.AbstractFacade;


/**
 * @generated DT_ID=none
 */
@Stateless(name = "AppRecursosBean", mappedName = "AppRecursosBean")
@Remote(AppRecursosFacadeRemote.class)
public class AppRecursosFacade extends AbstractFacade<AppRecurso> implements AppRecursosFacadeRemote
{
	 @PersistenceContext(unitName = "OMS_Persistencia")
	 private EntityManager em;
	
	
	 @Override
	    protected EntityManager getEntityManager() {
	        return em;
	    }
	
	 public AppRecursosFacade() {
	        super(AppRecurso.class);
	    }

	@Override
	public List<AppRecurso> findRecursosByUser(String emailUserID)
	{				        		      
			 if(emailUserID != null && emailUserID.length()>0)
			 {
				 		 		
		        //Objeto a devolver
		        List<AppRecurso> setAppRecursos = new ArrayList<AppRecurso>();
		         
		        String sqlNativo = "SELECT       "+
									"     app_recursos.idrecursos, app_recursos.nombre "+
									" FROM app_usuariosxrol uxr "+
									" INNER JOIN app_rolesxrequerimiento ON uxr.coderol = app_rolesxrequerimiento.coderol "+
									" INNER JOIN app_requerimiento ON app_rolesxrequerimiento.idrequerimiento = app_requerimiento.idrequerimiento "+
									" INNER JOIN app_recusosxrequerimiento ON app_requerimiento.idrequerimiento = app_recusosxrequerimiento.idrequerimiento "+
									" INNER JOIN app_recursos ON app_recusosxrequerimiento.idrecurso = app_recursos.idrecursos "+
									" WHERE uxr.email_usuario = '" + emailUserID + "'" + 
									" group by idrecursos, nombre "+
									" order by idrecursos asc";
		                
		        
		        Query query = em.createNativeQuery(sqlNativo);
		        
		        @SuppressWarnings("unchecked")
				List<Object[]> listado = query.getResultList();         
		        if(listado !=null && !listado.isEmpty())
		        {
		            for (Iterator<Object[]> it = listado.iterator(); it.hasNext();) 
		            {
		                Object[] resultElement = it.next();
		                
		                AppRecurso appRecursos = new  AppRecurso();	                
		                appRecursos.setIdrecursos(Short.valueOf(resultElement[0].toString()));
		                appRecursos.setNombre(resultElement[1].toString().trim());	                	               
		                setAppRecursos.add(appRecursos);
		            }                                                
		        }
		                        
		        return setAppRecursos;
			 }
			 
			 System.out.println("El parámetro recibido es NULL, se retorno NULL");
			 return null;		    		
	}
	 
	 
	
}
