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
	
	

}
