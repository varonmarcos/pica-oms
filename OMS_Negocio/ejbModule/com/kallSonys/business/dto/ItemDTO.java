package com.kallSonys.business.dto;

import java.io.Serializable;
import java.math.BigDecimal;


public class ItemDTO implements Serializable{

	
	private String ITEMID;
	private BigDecimal PRODID;
	private String PRODUCTNAME;
	private String PARTNUM;
	private BigDecimal PRICE;
	private BigDecimal QUANTITY;
	private String ORDERID;
	
	
	public String getITEMID() {
		return ITEMID;
	}
	public void setITEMID(String iTEMID) {
		ITEMID = iTEMID;
	}
	public BigDecimal getPRODID() {
		return PRODID;
	}
	public void setPRODID(BigDecimal pRODID) {
		PRODID = pRODID;
	}
	public String getPRODUCTNAME() {
		return PRODUCTNAME;
	}
	public void setPRODUCTNAME(String pRODUCTNAME) {
		PRODUCTNAME = pRODUCTNAME;
	}
	public String getPARTNUM() {
		return PARTNUM;
	}
	public void setPARTNUM(String pARTNUM) {
		PARTNUM = pARTNUM;
	}
	public BigDecimal getPRICE() {
		return PRICE;
	}
	public void setPRICE(BigDecimal pRICE) {
		PRICE = pRICE;
	}
	public BigDecimal getQUANTITY() {
		return QUANTITY;
	}
	public void setQUANTITY(BigDecimal qUANTITY) {
		QUANTITY = qUANTITY;
	}
	public String getORDERID() {
		return ORDERID;
	}
	public void setORDERID(String oRDERID) {
		ORDERID = oRDERID;
	}

	
}
