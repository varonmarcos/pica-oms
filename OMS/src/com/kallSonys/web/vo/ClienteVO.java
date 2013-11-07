package com.kallSonys.web.vo;

import java.io.Serializable;

/**
 * 
 * @author Juan Pablo Aranda Galvis
 * Esa clase representa un Objeto Cliente
 */
public class ClienteVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idCliente;
	private String nombreCliente;
	private String apellidoCliente;
	private String numeroTelefonico;
	private String email;
	private String password;
	private TipoTarjetaCreditoVO tipoTarjetaCredito;
	private String numeroTarjetaCredito;
	
	
	public ClienteVO(){
		
	}


	public String getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}


	public String getNombreCliente() {
		return nombreCliente;
	}


	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}


	public String getApellidoCliente() {
		return apellidoCliente;
	}


	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}


	public String getNumeroTelefonico() {
		return numeroTelefonico;
	}


	public void setNumeroTelefonico(String numeroTelefonico) {
		this.numeroTelefonico = numeroTelefonico;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public TipoTarjetaCreditoVO getTipoTarjetaCredito() {
		return tipoTarjetaCredito;
	}


	public void setTipoTarjetaCredito(TipoTarjetaCreditoVO tipoTarjetaCredito) {
		this.tipoTarjetaCredito = tipoTarjetaCredito;
	}


	public String getNumeroTarjetaCredito() {
		return numeroTarjetaCredito;
	}


	public void setNumeroTarjetaCredito(String numeroTarjetaCredito) {
		this.numeroTarjetaCredito = numeroTarjetaCredito;
	}
	
	
	

}
