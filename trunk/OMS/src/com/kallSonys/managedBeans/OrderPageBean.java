/**
 * 
 */
package com.kallSonys.managedBeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.kallSonys.business.dto.OrdenDTO;

/**
 * @author Juan Pablo Aranda Galvis
 *
 */
@ManagedBean(name="orderPageBean")
@RequestScoped
public class OrderPageBean {
	
	private OrdenDTO order;
	
	/**
	 * Minimal constructor
	 */
	public OrderPageBean(){
		
	}

	public OrdenDTO getOrder() {
		return order;
	}

	public void setOrder(OrdenDTO order) {
		this.order = order;
	}
	
	public void buscarOrders(){
		
		
	}

}
