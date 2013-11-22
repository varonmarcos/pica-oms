package com.kallSonys.business.dto;

import java.io.Serializable;

public class CustomerAddressDTO implements Serializable {

		
	private static final long serialVersionUID = 1L;
	
	private String CUSTADDID;
	private String CUSTID;
	private String ADDRESSID;
	
	
	public String getCUSTADDID() {
		return CUSTADDID;
	}
	public void setCUSTADDID(String cUSTADDID) {
		CUSTADDID = cUSTADDID;
	}
	public String getCUSTID() {
		return CUSTID;
	}
	public void setCUSTID(String cUSTID) {
		CUSTID = cUSTID;
	}
	public String getADDRESSID() {
		return ADDRESSID;
	}
	public void setADDRESSID(String aDDRESSID) {
		ADDRESSID = aDDRESSID;
	}
	
}
