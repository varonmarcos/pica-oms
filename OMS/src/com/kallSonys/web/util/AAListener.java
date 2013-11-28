package com.kallSonys.web.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.kallSonys.business.dto.AppRecursosDTO;
import com.kallSonys.business.dto.UserDTO;

//import com.kallSonys.seg.biz.transfer.user.UsersAuthenticatedDTO;

public class AAListener implements PhaseListener {
	
	private static final long serialVersionUID = 1L;
	private HashSet<String> urlsNoRestringidas = null; 
	private static String PATH_PROPERTIES = "com/kallSonys/web/util/urlsNoRestringidas.properties";

	@Override
	public void afterPhase(PhaseEvent phaseEvent) 
	{
		
         System.out.println("EJECUCION DEL LISTENER DE SEGURIDAD: {AAListener.afterPhase}");
            
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
		
		
		//Verificamos si el usuario ya está logeado
        //UsersAuthenticatedDTO usersAuthenticatedDTO = (UsersAuthenticatedDTO)CommonUtilities.obtenerAtributoSesion("usuarioAutenticadoDTO");
        //Se carga el listado de URL no restringidas     
		if ( this.urlsNoRestringidas==null )
        {
               System.out.println("AALISTENER: Se va cargar listado de URL no restringuidas");
		       this.cargarUrlsNoRestringidas();
		}
		
		//validamos que se allan cargado las urls no restringuidas
		if(this.urlsNoRestringidas != null && this.urlsNoRestringidas.size() > 0)
		{			
			if (  phaseid == PhaseId.RESTORE_VIEW )
	        {				
				navigationHandler = facescontext.getApplication().getNavigationHandler();
				String pagianDeLogin = "/OMS/faces/LoginPage.xhtml";
				String targetURL = uri; 
				
				System.out.println("AALISTENER: DESTINO: "+targetURL);
				//Permitir acceder al uri que muestra la pagina de login
		        if (( targetURL != null ) && targetURL.equals( pagianDeLogin )) 		        
		        {	
		        	//Permitimos pasar a la página de login
		        }
		        else
		        {
		        	System.out.println("-------------RESTORE_VIEW---------------");	
		        	
					//----------------Verificando si el usuario está en login
					UserDTO usersAuthenticatedDTO = (UserDTO)CommonUtilities.obtenerAtributoSesion("usuarioAutenticadoDTO");	
					System.out.println("AALISTENER: Verificamos si el usuario està en session es decir hizo login: "+usersAuthenticatedDTO);								
					if(usersAuthenticatedDTO==null)
					{
						System.out.println("AALISTENER: navigationHandler Goto SALIR");									
						navigationHandler.handleNavigation(facescontext, null, "Salir");	
					}
					else
					{
						System.out.println("AALISTENER: El usuario está logeado");
						System.out.println("AALISTENER: Verificar acceso a url destino");
						facescontext = phaseEvent.getFacesContext();
						request = (HttpServletRequest)facescontext.getExternalContext().getRequest();								
						uri = request.getRequestURI();	
						targetURL = uri;
						//---------------Verificamos si el usuario tiene permiso al recurso que intenta acceder											
						if ( urlsNoRestringidas.contains(targetURL) )//targetURL  //"/OMS/faces/pages/ProductoPage.xhtml"
						{
							System.out.println("Recurso dentro de el conjunto de urls no restringidas en el properties "+PATH_PROPERTIES);
							navigationHandler.handleNavigation(facescontext, null, targetURL);	
			        	}
						else if ( !urlAutorizada( usersAuthenticatedDTO.getListadoRecursos(), targetURL ))
						{
							System.out.println("AALISTENER: El usuario no tiene autorizacion, no permitir ir al recurso[" + uri + "]" );					        			        	
			        		navigationHandler.handleNavigation(facescontext, null, "mensajesError");			        						        					        
				        }
						else 
						{
							
						}																													
					}	
		        }																	                                    				  
			}
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
	@SuppressWarnings("unused")
	private boolean urlAutorizada(List<AppRecursosDTO> listadoRecursosUsuario, String targetURL) {
		boolean perimitirAcceso = false;		
		for ( AppRecursosDTO recursoItem : listadoRecursosUsuario ) 
		{			
			if ( targetURL.trim().toLowerCase().equals( recursoItem.getNombre().toLowerCase().trim()) ) 
			{
				perimitirAcceso = true;
				break;
			}
	    }					
		return perimitirAcceso; 
	}
	
	@SuppressWarnings("unused")
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
