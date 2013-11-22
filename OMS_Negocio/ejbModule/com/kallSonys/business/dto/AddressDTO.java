package com.kallSonys.business.dto;

import java.io.Serializable;

public class AddressDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	private String ADDRID;
	private String STREET;
	private String STATE;
	private String ZIP;
	private String COUNTRY;
	private String ADDRESSTYPE;
	private String CITY;
	
	
	public String getADDRID() {
		return ADDRID;
	}
	public void setADDRID(String aDDRID) {
		ADDRID = aDDRID;
	}
	public String getSTREET() {
		return STREET;
	}
	public void setSTREET(String sTREET) {
		STREET = sTREET;
	}
	public String getSTATE() {
		return STATE;
	}
	public void setSTATE(String sTATE) {
		STATE = sTATE;
	}
	public String getZIP() {
		return ZIP;
	}
	public void setZIP(String zIP) {
		ZIP = zIP;
	}
	public String getCOUNTRY() {
		return COUNTRY;
	}
	public void setCOUNTRY(String cOUNTRY) {
		COUNTRY = cOUNTRY;
	}
	public String getADDRESSTYPE() {
		return ADDRESSTYPE;
	}
	public void setADDRESSTYPE(String aDDRESSTYPE) {
		ADDRESSTYPE = aDDRESSTYPE;
	}
	public String getCITY() {
		return CITY;
	}
	public void setCITY(String cITY) {
		CITY = cITY;
	}
	
	
	
	
}
