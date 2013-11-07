package com.kallSonys.managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

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
	
	private List<SelectItem> listTipoTarjetas;
	private TipoTarjetaCreditoVO tipoTarjetaCredito;
	private boolean mostrarCrearProducto;
	
	public ProductoPageBean(){
		System.out.println("entro");
	}
	
	/**
	 * Este metodo Inicializa el listado de tipo de tarjetas
	 */
	
	public List<SelectItem> getListTipoTarjetas() {
		if(this.listTipoTarjetas==null){
			TipoTarjetaCreditoVO tvisa=new TipoTarjetaCreditoVO("1","Visa");
			TipoTarjetaCreditoVO tmaster=new TipoTarjetaCreditoVO("2","Masterd Card");
			this.listTipoTarjetas=new ArrayList<SelectItem>();
			this.listTipoTarjetas.add(new SelectItem(tvisa.getIdTipoTarjeta(),tvisa.getNombreTipoTarjeta()));
			this.listTipoTarjetas.add(new SelectItem(tmaster.getIdTipoTarjeta(),tmaster.getNombreTipoTarjeta()));
		}
		return listTipoTarjetas;
	}

	public void setListTipoTarjetas(List<SelectItem> listTipoTarjetas) {
		this.listTipoTarjetas = listTipoTarjetas;
	}

	public TipoTarjetaCreditoVO getTipoTarjetaCredito() {
		return tipoTarjetaCredito;
	}

	public void setTipoTarjetaCredito(TipoTarjetaCreditoVO tipoTarjetaCredito) {
		this.tipoTarjetaCredito = tipoTarjetaCredito;
	}

	public boolean isMostrarCrearProducto() {
		return mostrarCrearProducto;
	}

	public void setMostrarCrearProducto(boolean mostrarCrearProducto) {
		this.mostrarCrearProducto = mostrarCrearProducto;
	}
	
	

}
