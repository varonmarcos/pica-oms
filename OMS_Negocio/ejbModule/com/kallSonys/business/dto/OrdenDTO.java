/**
 * 
 */
package com.kallSonys.business.dto;

import java.io.Serializable;

/**
 * @author Bernardo
 *
 */
public class OrdenDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String orderId;
	private String customerId;
	private String orderDate;
	private double price;
	private String status;
	private String comments;
	
	/**
	 * Minimal Constructor
	 */
	@SuppressWarnings("unused")
	private OrdenDTO(){
		
	}

	public OrdenDTO(String orderId, String customerId, String orderDate,
			double price, String status, String comments) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.orderDate = orderDate;
		this.price = price;
		this.status = status;
		this.comments = comments;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	
}
