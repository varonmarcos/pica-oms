/**
 * 
 */
package com.kallSonys.managedBeans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.kallSonys.web.sesion.SessionBean;

/**
 * @author juanaranda
 *
 */
@ManagedBean(name="principalPageBean")
@RequestScoped
public class PrincipalPageBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@ManagedProperty(value="#{sessionBean}")
	private SessionBean sessionBean;
	
	public PrincipalPageBean(){
		
	}
	
	public String gotoProductosPage(){
		return "goToProductos";
	}
	
	public String gotoCamapañasPage(){
		return "goToCapamañas";
	}
	
	public String gotoOrdenesPage(){
		return "goToOrdenes";
	}
	
	public String gotoClientesPage(){
		return "goToClientes";
	}

}
