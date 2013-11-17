package com.kallSonys.business.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author juanaranda
 *
 */
public class TipoTarjetaCreditoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String idTipoTarjeta;
	private String nombreTipoTarjeta;
	
	public TipoTarjetaCreditoDTO(){
		
	}
	
	public TipoTarjetaCreditoDTO(String idTipoTarjeta,String nombreTipoTarjeta){
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
	
	public static List<TipoTarjetaCreditoDTO> preloadData(){
		List<TipoTarjetaCreditoDTO> listadoTarjetas=new ArrayList<TipoTarjetaCreditoDTO>();
		TipoTarjetaCreditoDTO visa=new TipoTarjetaCreditoDTO("1","Visa");
		TipoTarjetaCreditoDTO master=new TipoTarjetaCreditoDTO("2","Masterd Card");
		listadoTarjetas.add(visa);
		listadoTarjetas.add(master);		
		return listadoTarjetas;
		
	}

}
