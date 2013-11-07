/**
 * 
 */
package com.kallSonys.managedBeans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;

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
	
	@SuppressWarnings("unused")
	public void formCreaProductoListener(ActionEvent event){
		
		String action= (String)event.getComponent().getAttributes().get("actionCreaProductos");
		if(action.equals("1")){
			this.sessionBean.setShowFormCrearProducto(Boolean.TRUE);
		}else{
			this.sessionBean.setShowFormCrearProducto(Boolean.TRUE);
		}
		System.out.println(this.sessionBean.isShowFormCrearProducto());
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

	public SessionBean getSessionBean() {
		return sessionBean;
	}

	public void setSessionBean(SessionBean sessionBean) {
		this.sessionBean = sessionBean;
	}
	
	

}
