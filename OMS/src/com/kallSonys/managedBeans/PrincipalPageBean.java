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
public class PrincipalPageBean{

	private static final long serialVersionUID = 1L;
	
	
	@ManagedProperty(value="#{sessionBean}")
	private SessionBean sessionBean;
	
	public PrincipalPageBean(){
		
	}
	
	public String gotoProductoPage(){
		return "goToProducto";
	}
	
	@SuppressWarnings("unused")
	public void formCreaProductoListener(ActionEvent event){
		
		String action= (String)event.getComponent().getAttributes().get("actionCreaProductos");
		if(action.equals("1")){
			this.sessionBean.setShowFormCrearProducto(Boolean.TRUE);
			this.sessionBean.setShowFormConsultarProducto(Boolean.FALSE);
		}else{
			this.sessionBean.setShowFormConsultarProducto(Boolean.TRUE);
			this.sessionBean.setShowFormCrearProducto(Boolean.FALSE);
		}
		
	}
	
	@SuppressWarnings("unused")
	public void formCreaClienteListener(ActionEvent event){
		
		String action= (String)event.getComponent().getAttributes().get("actionCreaCliente");
		if(action.equals("1")){
			this.sessionBean.setShowFormCrearCliente(Boolean.TRUE);
			this.sessionBean.setShowFormConsultaCliente(Boolean.FALSE);
		}else{
			this.sessionBean.setShowFormCrearCliente(Boolean.FALSE);
			this.sessionBean.setShowFormConsultaCliente(Boolean.TRUE);
		}
		
	}
	
	@SuppressWarnings("unused")
	public void formCreaCampanaListener(ActionEvent event){
		
		String action= (String)event.getComponent().getAttributes().get("actionCreaCampaña");
		if(action.equals("1")){
			this.sessionBean.setShowFormCrearCampana(Boolean.TRUE);
			this.sessionBean.setShowFormConsultaCampana(Boolean.FALSE);
		}else{
			this.sessionBean.setShowFormCrearCampana(Boolean.FALSE);
			this.sessionBean.setShowFormConsultaCampana(Boolean.TRUE);
		}
		
	}
	
	public String gotoCamapanaPage(){
		return "goToCampana";
	}
	
	public String gotoOrdenePage(){
		return "goToOrdene";
	}
	
	public String gotoClientePage(){
		return "goToCliente";
	}

	public SessionBean getSessionBean() {
		return sessionBean;
	}

	public void setSessionBean(SessionBean sessionBean) {
		this.sessionBean = sessionBean;
	}
	
	

}
