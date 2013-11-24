/**
 * 
 */
package com.kallSonys.business.enums;

/**
 * @author Juan Pablo Aranda Galvis
 *
 */
public enum enumCustomerType {
	
	Plateado("0"), Dorado("1"),Platino("2");
	 
	private String statusCode;
 
	private enumCustomerType(String s) {
		statusCode = s;
	}
 
	public String getStatusCode() {
		return statusCode;
	}

}

