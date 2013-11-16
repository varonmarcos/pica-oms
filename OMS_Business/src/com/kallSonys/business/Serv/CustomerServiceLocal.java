/**
 * 
 */
package com.kallSonys.business.Serv;

import javax.ejb.Remote;

import com.kallSonys.business.dto.CustomerDTO;

/**
 * @author Juan Pablo Aranda Galvis
 *
 */

@Remote
public interface CustomerServiceLocal {
	
	public Boolean createCustomer(CustomerDTO customer);
	
	public CustomerDTO getCustomers();

}
