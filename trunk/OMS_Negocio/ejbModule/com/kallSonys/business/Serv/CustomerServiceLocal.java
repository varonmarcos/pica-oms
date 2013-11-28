/**;
 * 
 */
package com.kallSonys.business.Serv;

import java.util.List;
import java.util.Map;

import javax.ejb.Remote;

import com.kallSonys.business.dto.CustomerDTO;

/**
 * @author Juan Pablo Aranda Galvis
 *
 */

@Remote
public interface CustomerServiceLocal {
	
	public String createAndReturnID(CustomerDTO customer);
	
	public boolean createCustomer(CustomerDTO customer);
	
	public boolean doUpdateCustomer(CustomerDTO customer);
	
	public CustomerDTO getCustomers();

	public List<CustomerDTO> getCustomerByIdentificador(Map<String,Object> parameters);
	
	public List<CustomerDTO> getCustomerByIdProduct(Map<String,Object> parameters);
	
	public List<CustomerDTO> getCustomerByIdFacturacion(Map<String,Object> parameters);
	

}
