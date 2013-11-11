package com.kallSonys.seg.biz.web.utilidades;

import java.util.Map;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;


@SuppressWarnings("serial")
public abstract class UtilidadesJSB {

	/**
	 * Se encarga de retornar un atributo de la sesion
	 * 
	 * @param key clave del atributo en la sesion
	 * @return 
	 */
	protected Object obtenerAtributoSesion ( String key ){
		ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
		return ((HttpSession)ctx.getSession(false)).getAttribute(key);
	}
	
	
	/**
	 * Remueve un atributo de la session
	 * 
	 * @param key clave del atributo en la sesion
	 * @return 
	 */
	protected void removerAtributoSesion ( String key ){
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
	protected void ponerAtributoSesion ( String key,Object attribute ){
		ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
		((HttpSession)ctx.getSession(false)).setAttribute(key, attribute);
	}

	/**
	 * Se encarga de obtener la ip del usuario autenticado
	 */
	protected String obtenerIp(){
		return ((ServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getRemoteAddr();
	}			
		
	public void sessionReset()
        {
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		for ( String key:sessionMap.keySet() ){
			if (!key.contains("LoginPageBean")&&!key.contains("datosUsuarioAutenticado"))
                        {
				sessionMap.remove(key);
			}
		}			
	}

}
