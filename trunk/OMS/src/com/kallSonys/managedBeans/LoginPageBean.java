package com.kallSonys.managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.kallSonys.business.Serv.LoginServiceLocal;
import com.kallSonys.business.dto.UserDTO;
import com.kallSonys.web.sesion.SessionBean;
import com.kallSonys.web.util.CommonUtilities;

@ManagedBean(name="loginPageBean")
@RequestScoped
public class LoginPageBean implements Serializable {
	   
	private static final long serialVersionUID = 1L;
	
	@EJB (mappedName="LoginServiceBean")
	LoginServiceLocal loginService;
	@ManagedProperty(value="#{sessionBean}")
	private SessionBean sessionBean;
	FacesContext context = FacesContext.getCurrentInstance();
	private String user;
	private String password;
	
	
	
	public LoginPageBean(){}
	
	
	/**
	 * Este metodo iniciar la logica 
	 * para autenticar el usuario
	 * el login se hace frente al OpenLdap
	 */
	public String loginAction()
	{ 
		try{
			//Informacion usuario en session		
			UserDTO user = new UserDTO();				
			user.setUser(this.getUser());		
			user.setPassword(this.getPassword());	
					
			System.out.println("El ben es: "+loginService);
			
			user = loginService.login(user);
			if(user.isAutenticado())		
			{			
				//Se coloca en sesion los recursos a los que tiene acceso el personaje 
				//logeado contra LDAP y según los roles del mismo
				CommonUtilities.ponerAtributoSesion("usuarioAutenticadoDTO", user);			
				this.sessionBean.setUserInSession(user);
				return "exito";
			}
		}catch (Exception e) {
			context.addMessage(null, new FacesMessage("Ocurrio un error al realizar login")); 
			e.printStackTrace();
					
		}
		
					
		return "";
	}
	
		
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


	public LoginServiceLocal getLoginService() {
		return loginService;
	}


	public void setLoginService(LoginServiceLocal loginService) {
		this.loginService = loginService;
	}


	public SessionBean getSessionBean() {
		return sessionBean;
	}


	public void setSessionBean(SessionBean sessionBean) {
		this.sessionBean = sessionBean;
	}
	

}
