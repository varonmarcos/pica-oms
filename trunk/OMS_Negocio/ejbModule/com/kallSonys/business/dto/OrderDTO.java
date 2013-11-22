package com.kallSonys.business.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class OrderDTO implements Serializable{

	
	
	private String CUSTID;
	private String ORDERID;
	private Date ORDERDATE;
	private BigDecimal PRICE;
	private String STATUS;
	private String COMMENTS;

	//Objetos relacionados	
	private CustomerDTO customerDTO;
	private List<ItemDTO> listadoItemsDTO;
	
	
	
	public String getCUSTID() {
		return CUSTID;
	}
	public void setCUSTID(String cUSTID) {
		CUSTID = cUSTID;
	}
	public String getORDERID() {
		return ORDERID;
	}
	public void setORDERID(String oRDERID) {
		ORDERID = oRDERID;
	}
	public Date getORDERDATE() {
		return ORDERDATE;
	}
	public void setORDERDATE(Date oRDERDATE) {
		ORDERDATE = oRDERDATE;
	}
	public BigDecimal getPRICE() {
		return PRICE;
	}
	public void setPRICE(BigDecimal pRICE) {
		PRICE = pRICE;
	}
	public String getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}
	public String getCOMMENTS() {
		return COMMENTS;
	}
	public void setCOMMENTS(String cOMMENTS) {
		COMMENTS = cOMMENTS;
	}
	public CustomerDTO getCustomerDTO() {
		return customerDTO;
	}
	public void setCustomerDTO(CustomerDTO customerDTO) {
		this.customerDTO = customerDTO;
	}
	public List<ItemDTO> getListadoItemsDTO() {
		return listadoItemsDTO;
	}
	public void setListadoItemsDTO(List<ItemDTO> listadoItemsDTO) {
		this.listadoItemsDTO = listadoItemsDTO;
	}
	
	
}
