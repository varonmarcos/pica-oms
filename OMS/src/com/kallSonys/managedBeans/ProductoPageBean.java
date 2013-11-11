package com.kallSonys.managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

import com.kallSonys.web.vo.ProductoVO;
import com.kallSonys.web.vo.TipoTarjetaCreditoVO;

/**
 * 
 * @author juanaranda
 *
 */
@ManagedBean(name="productoPageBean")
@RequestScoped
public class ProductoPageBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private boolean mostrarCrearProducto;
	private ProductoVO productoVO;
	
	public ProductoPageBean(){
		
	}
	
	/**
	 * Este metodo Inicializa el listado de tipo de tarjetas
	 */
	
	
	public boolean isMostrarCrearProducto() {
		return mostrarCrearProducto;
	}

	public void setMostrarCrearProducto(boolean mostrarCrearProducto) {
		this.mostrarCrearProducto = mostrarCrearProducto;
	}
	
	

}
