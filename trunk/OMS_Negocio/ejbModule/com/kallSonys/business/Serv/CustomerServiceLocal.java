/**;
 * 
 */
package com.kallSonys.business.Serv;

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
	
	public CustomerDTO getCustomers();

	public CustomerDTO getCustomerByIdentificador(Map<String,Object> identificacion);
	
	public CustomerDTO getCustomerByIdProduct(Map<String,Object> idProducto);
	
	public CustomerDTO getCustomerByIdFacturacion(Map<String,Object> facturacion);

}
