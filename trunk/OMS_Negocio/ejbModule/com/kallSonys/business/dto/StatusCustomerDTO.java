/**
 * 
 */
package com.kallSonys.business.dto;

import java.util.ArrayList;
import java.util.List;

import com.kallSonys.business.enums.enumeEstadoCliente;

/**
 * @author Juan Pablo Aranda
 *
 */
public class StatusCustomerDTO {
	
	private String codigo;
	private String descripcion;
	
	public StatusCustomerDTO(){
		
	}
	
	public StatusCustomerDTO(String codigo, String descripcion) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
	}


	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public static List<StatusCustomerDTO> preloadData(){
		List<StatusCustomerDTO> listadoTarjetas=new ArrayList<StatusCustomerDTO>();
		StatusCustomerDTO s1=new StatusCustomerDTO(enumeEstadoCliente.ACTIVE.getStatusCode(),enumeEstadoCliente.ACTIVE.name());
		StatusCustomerDTO s2=new StatusCustomerDTO(enumeEstadoCliente.INACTIVE.getStatusCode(),enumeEstadoCliente.INACTIVE.name());
		listadoTarjetas.add(s1);
		listadoTarjetas.add(s2);		
		return listadoTarjetas;
		
	}
	

}
