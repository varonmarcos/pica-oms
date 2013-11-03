/**
 * 
 */
package com.kallSonys.managedBeans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

/**
 * @author juanaranda
 *
 */
@ManagedBean(name="principalPageBean")
public class PrincipalPageBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
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
