package com.kallSonys.managedBeans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="loginPageBean")
@RequestScoped
public class LoginPageBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String user;
	private String password;
	
	public LoginPageBean(){}
	
	/**
	 * Este metodo iniciar la logica 
	 * para autenticar el usuario
	 */
	public String loginAction(){
		System.out.println("El usuario es:"+this.user);
		System.out.println("El usuario es:"+this.password);
		return "exito";
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

}
