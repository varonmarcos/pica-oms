/**
 * 
 */
package com.kallSonys.business.enums;

/**
 * @author Juan Pablo Aranda Galvis
 *
 */
public enum enumeEstadoCliente {
	ACTIVE("1"), INACTIVE("0");
	 
	private String statusCode;
 
	private enumeEstadoCliente(String s) {
		statusCode = s;
	}
 
	public String getStatusCode() {
		return statusCode;
	}

}
