package com.kallSonys.managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.kallSonys.business.Serv.LoginServiceLocal;
import com.kallSonys.business.dto.UserDTO;
import com.kallSonys.common.dal.jpa.entitys.AppRecurso;
import com.kallSonys.seg.biz.transfer.user.UsersAuthenticatedDTO;
import com.kallSonys.web.util.CommonUtilities;

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
			 		
		//Informacion usuario en session		
		UsersAuthenticatedDTO usuarioAutenticado = new  UsersAuthenticatedDTO();
		UserDTO user = new UserDTO();				
		user.setUser(this.getUser());		
		user.setPassword(this.getPassword());	
				
		System.out.println("El ben es: "+loginService);
		
		usuarioAutenticado = loginService.login(user);
		if(usuarioAutenticado.isAutenticado())		
		{			
			//Se coloca en sesion los recursos a los que tiene acceso el personaje 
			//logeado contra LDAP y según los roles del mismo
			CommonUtilities.ponerAtributoSesion("usuarioAutenticadoDTO", usuarioAutenticado);			
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
