package com.kallSonys.seg.biz.web.utilidades;

import com.kallSonys.seg.biz.transfer.UsersAuthenticatedDTO;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.HashSet;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AAListener implements PhaseListener {
	
	private static final long serialVersionUID = 1L;
	private HashSet<String> urlsNoRestringidas = null;
                
	private static final String PATH_PROPERTIES = "com/kallSonys/seg/biz/configuration/resources/urlsNoRestringidas.properties";
	
	

	@Override
	public void afterPhase(PhaseEvent phaseEvent) {
		
            System.out.println("Inica clase: afterPhase");
            
		FacesContext facescontext = null;
		HttpServletRequest request = null;
		HttpSession session = null;
		String showLoginAction = null;		
		String uri = null;
		NavigationHandler navigationHandler = null;		
		PhaseId phaseid = phaseEvent.getPhaseId();
			
		facescontext = phaseEvent.getFacesContext();
		request = (HttpServletRequest)facescontext.getExternalContext().getRequest();
		uri = request.getRequestURI();
		session = request.getSession();
		
		
                UsersAuthenticatedDTO usersAuthenticatedDTO=null;
                
		if ( this.urlsNoRestringidas==null )
                {
                       System.out.println("Se van a cargar listado de URLs no restringuidas");
		       this.cargarUrlsNoRestringidas();
		}
		
		if (  phaseid == PhaseId.RESTORE_VIEW )
                {
                        System.out.println("PhaseId.RESTORE_VIEW");
                        
			facescontext = phaseEvent.getFacesContext();
			request = (HttpServletRequest)facescontext.getExternalContext().getRequest();
			showLoginAction = "LoginPage.xhtml";			
			uri = request.getRequestURI();
			navigationHandler = facescontext.getApplication().getNavigationHandler();			 
			int firstSlash = uri.indexOf("/jsp", 1);
	        
		}
                System.out.println("afterPhase FIN");
	}
	
	
	
	/**
	 * Verifica dentro de la coleccion de recursos si existe la url solicitada.
	 * 
	 * @param recursosVOSet Coleccion de URL a las que el rol tiene acceso.
	 * @param targetURL     URL solicitada.
	 * @return              true si se permite acceder a la URL, false en caso contrario.
	 */
	private boolean urlAutorizada() {
		boolean perimitirAcceso = true;		
				
		
		
		return perimitirAcceso; 
	}
	
	
	private void cargarUrlsNoRestringidas ( )
        {
            
            InputStream inputStream = AAListener.class.getClassLoader().getResourceAsStream(PATH_PROPERTIES);

            if (inputStream == null) 
            {
                    System.out.println("No se encontro el archivo de configuracion["+ PATH_PROPERTIES + "]");
                    return;
            }
            this.urlsNoRestringidas = new HashSet<String>();
            BufferedReader lector = new BufferedReader(new InputStreamReader(inputStream));
            String linea = null;
            try
            {
                while ( (linea = lector.readLine())!=null )
                {                    
                        this.urlsNoRestringidas.add(linea.trim());
                        System.out.println("URL NO RESTRINGIDA CARGADA: "+linea.trim());
                }
            }catch (Exception e) 
            {
                    System.out.println("Error cargarUrlsNoRestringidas: "+e);
                    return;
            }
		
	}

	@Override
	public void beforePhase(PhaseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
