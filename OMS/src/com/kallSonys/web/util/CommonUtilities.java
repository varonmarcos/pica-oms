package com.kallSonys.web.util;

import java.util.Map;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@SuppressWarnings("serial")
public abstract class CommonUtilities {

	/**
	 * Se encarga de retornar un atributo de la sesion
	 * 
	 * @param key clave del atributo en la sesion
	 * @return 
	 */
	public static Object obtenerAtributoSesion ( String key ){
		ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
		return ((HttpSession)ctx.getSession(false)).getAttribute(key);
	}
	
	
    /**
    * Remueve un atributo de la session
     * 
     * @param key clave del atributo en la sesion
     * @return 
     */
	public static void removerAtributoSesion ( String key ){
		ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
		((HttpSession)ctx.getSession(false)).removeAttribute(key);
	}
	
	/**
	 * Se encarga de poner un atributo en la sesion
	 * 
	 * @param key clave del atributo en la sesion
	 * @param atributo Atributo para poner en la sesion
	 * 
	 */
	public static void ponerAtributoSesion ( String key,Object attribute ){
		ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
		((HttpSession)ctx.getSession(false)).setAttribute(key, attribute);
	}

	/**
	 * Se encarga de obtener la ip del usuario autenticado
	 */
	public static String obtenerIp(){
		return ((ServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getRemoteAddr();
	}			
		
	public void sessionReset()
    {
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		for ( String key:sessionMap.keySet() )
		{
			if (!key.contains("LoginPageBean")&&!key.contains("datosUsuarioAutenticado"))
            {
				sessionMap.remove(key);
			}
		}			
	}
	
	/*
	 * MANEJO DE OBJETOD EN request
	 * */
	

	/**
	 * Asigna un atributo en el Request.
	 * 
	 * @param key
	 *            Identificador del atributo en el Request.
	 * @param object
	 *            Atributo que se asigna en el Request.
	 */
	public static void setAttributeRequest(String key, Object object) 
	{
		HttpServletRequest request = null;
		request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		request.setAttribute(key, object);
	}

	/**
	 * Obtiene un atributo del Request.
	 * 
	 * @param key
	 *            Identificador del atributo en el Request.
	 * @return Atributo localizado.
	 */
	public static Object getAttributeRequest(String key) 
	{
		HttpServletRequest request = null;
		request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		return request.getAttribute(key);
	}



}
