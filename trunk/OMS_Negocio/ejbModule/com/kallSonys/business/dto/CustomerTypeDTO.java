/**
 * 
 */
package com.kallSonys.business.dto;

import java.util.ArrayList;
import java.util.List;

import com.kallSonys.business.enums.enumCustomerType;
import com.kallSonys.business.enums.enumeEstadoCliente;

/**
 * @author Juan Pablo Aranda Galvis
 *
 */
public class CustomerTypeDTO {
	
	private String codigo;
	private String descripcion;
	
	/**
	 * Minimal Constructor
	 */
	public CustomerTypeDTO(){
		
	}
	public CustomerTypeDTO(String codigo, String descripcion) {
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
	
	public static List<CustomerTypeDTO> preloadData(){
		List<CustomerTypeDTO> listadoTarjetas=new ArrayList<CustomerTypeDTO>();
		CustomerTypeDTO s1=new CustomerTypeDTO(enumCustomerType.Plateado.getStatusCode(),enumCustomerType.Plateado.name());
		CustomerTypeDTO s2=new CustomerTypeDTO(enumCustomerType.Dorado.getStatusCode(),enumCustomerType.Dorado.name());
		CustomerTypeDTO s3=new CustomerTypeDTO(enumCustomerType.Platino.getStatusCode(),enumCustomerType.Platino.name());
		listadoTarjetas.add(s1);
		listadoTarjetas.add(s2);
		listadoTarjetas.add(s3);
		return listadoTarjetas;
		
	}
}
