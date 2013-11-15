/**
 * 
 */
package com.kallSonys.business.Serv;

import javax.ejb.Local;

import com.kallSonys.business.dto.CustomerDTO;

/**
 * @author Juan Pablo Aranda Galvis
 *
 */

@Local
public interface CustomerServiceLocal {
	
	public Boolean createCustomer(CustomerDTO customer);
	
	public CustomerDTO getCustomers();

}
