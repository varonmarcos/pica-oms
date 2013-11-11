package com.kallSonys.managedBeans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.kallSonys.common.dal.jpa.facade.AddressFacade;
import com.kallSonys.common.dal.jpa.facade.AddressFacadeLocal;
import com.kallSonys.seg.biz.ldap.facade.LdapFacade;
import com.kallSonys.seg.biz.transfer.user.UsersDTO;

@ManagedBean(name="loginPageBean")
@RequestScoped
public class LoginPageBean implements Serializable {
	   
	private static final long serialVersionUID = 1L;
	@EJB (mappedName="LdapBean")
	LdapFacade ldapFacadeBean;
	
	@EJB (mappedName="AddressBean")
	AddressFacadeLocal AddressFacadeLocalBean;
     
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
			 			
		UsersDTO user = new UsersDTO();		
		user.setUser(this.getUser());		
		user.setPass(this.getPassword());	
		
		System.out.println("El ben es: "+AddressFacadeLocalBean);
		if(AddressFacadeLocalBean!=null)
		{
			System.out.println("Cantidad de registros en tabla address: "+AddressFacadeLocalBean.count());
		}
		user = ldapFacadeBean.connect(user);
		if(user.isAutenticado())		
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

}
