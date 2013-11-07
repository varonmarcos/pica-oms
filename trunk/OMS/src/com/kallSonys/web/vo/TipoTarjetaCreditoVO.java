package com.kallSonys.web.vo;

import java.io.Serializable;

/**
 * 
 * @author juanaranda
 *
 */
public class TipoTarjetaCreditoVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String idTipoTarjeta;
	private String nombreTipoTarjeta;
	
	public TipoTarjetaCreditoVO(String idTipoTarjeta,String nombreTipoTarjeta){
		this.idTipoTarjeta=idTipoTarjeta;
		this.nombreTipoTarjeta=nombreTipoTarjeta;
		
	}

	public String getIdTipoTarjeta() {
		return idTipoTarjeta;
	}

	public void setIdTipoTarjeta(String idTipoTarjeta) {
		this.idTipoTarjeta = idTipoTarjeta;
	}

	public String getNombreTipoTarjeta() {
		return nombreTipoTarjeta;
	}

	public void setNombreTipoTarjeta(String nombreTipoTarjeta) {
		this.nombreTipoTarjeta = nombreTipoTarjeta;
	}
	
	
	

}
