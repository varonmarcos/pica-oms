package com.kallSonys.managedBeans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.kallSonys.business.Interfaces.LoginServiceLocal;
import com.kallSonys.business.dto.UserDTO;

@ManagedBean(name="loginPageBean")
@RequestScoped
public class LoginPageBean implements Serializable {
	   
	private static final long serialVersionUID = 1L;
	
	@EJB (mappedName="LoginServiceBean")
	LoginServiceLocal loginService;
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
			 			
		UserDTO user = new UserDTO();		
		user.setUser(this.getUser());		
		user.setPassword(this.getPassword());	
		
		System.out.println("El ben es: "+loginService);
		
		loginService.login(user);
		if(loginService.login(user))		
		{								
			return "exito";
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
	

}
