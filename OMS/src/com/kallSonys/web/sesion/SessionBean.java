package com.kallSonys.web.sesion;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name="sessionBean")
@SessionScoped
public class SessionBean implements Serializable {

	private static final long serialVersionUID = 2356312790334503309L;
	
	private boolean showFormCrearProducto;
	private boolean showFormConsultarProducto;
	private boolean showFormCrearCliente;
	private boolean showFormConsultaCliente;
	private boolean showFormCrearCampana;
	private boolean showFormConsultaCampana;
	
	public SessionBean(){
		
	}

	public boolean isShowFormCrearProducto() {
		return showFormCrearProducto;
	}

	public void setShowFormCrearProducto(boolean showFormCrearProducto) {
		this.showFormCrearProducto = showFormCrearProducto;
	}

	public boolean isShowFormConsultarProducto() {
		return showFormConsultarProducto;
	}

	public void setShowFormConsultarProducto(boolean showFormConsultarProducto) {
		this.showFormConsultarProducto = showFormConsultarProducto;
	}

	public boolean isShowFormCrearCliente() {
		return showFormCrearCliente;
	}

	public void setShowFormCrearCliente(boolean showFormCrearCliente) {
		this.showFormCrearCliente = showFormCrearCliente;
	}

	public boolean isShowFormConsultaCliente() {
		return showFormConsultaCliente;
	}

	public void setShowFormConsultaCliente(boolean showFormConsultaCliente) {
		this.showFormConsultaCliente = showFormConsultaCliente;
	}

	public boolean isShowFormCrearCampana() {
		return showFormCrearCampana;
	}

	public void setShowFormCrearCampana(boolean showFormCrearCampana) {
		this.showFormCrearCampana = showFormCrearCampana;
	}

	public boolean isShowFormConsultaCampana() {
		return showFormConsultaCampana;
	}

	public void setShowFormConsultaCampana(boolean showFormConsultaCampana) {
		this.showFormConsultaCampana = showFormConsultaCampana;
	}
	
	

}
