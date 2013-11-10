package com.kallSonys.managedBeans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.kallSonys.common.dal.jpa.facade.AddressFacadeLocal;
import com.kallSonys.common.dal.ldap.mnr.LdapManager;
import com.kallSonys.seg.biz.transfer.UsersDTO;

@ManagedBean(name="loginPageBean")
@RequestScoped
public class LoginPageBean implements Serializable {

	@EJB(mappedName="AddressBean")
    private AddressFacadeLocal addressFacadeLocal;	
	private static final long serialVersionUID = 1L;
	 
     
	private String user;
	private String password;
	
	
	
	public LoginPageBean(){}
	
	/**
	 * Este metodo iniciar la logica 
	 * para autenticar el usuario
	 */
	public String loginAction()
	{
			 
		LdapManager mnr = new LdapManager();		
		UsersDTO user = new UsersDTO();		
		user.setUser(this.getUser());		
		user.setPass(this.getPassword());		
		user = mnr.connect(user);
		if(user.isAutenticado())		
		{			
			System.out.println("Usuario logeado, redirigir a la pagina de inicio");
			pruebaBeanJPA();
			System.out.println("Ejecutó llamado Bean JPA");
			return "exito";
		}
		
		System.out.println("No se logró logear el usuario.");
	
		return "";
	}
	
	private void pruebaBeanJPA()
	{
		
		//addressFacadeLocal = new  AddressFacadeLocal();
		//addressBean = new  AddressFacadeLocal();
		System.out.println("prueba bean 1: ");
		System.out.println("llamado bean: "+addressFacadeLocal.count());
		System.out.println("prueba bean 2: ");
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
