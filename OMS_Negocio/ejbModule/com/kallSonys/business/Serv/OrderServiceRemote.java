/**
 * 
 */
package com.kallSonys.business.Serv;

import javax.ejb.Remote;

import com.kallSonys.business.dto.OrderDTO;

 
/**
 * @author Frank Arregocés Rodríguez
 *
 */
@Remote
public interface OrderServiceRemote {
	
	public String crearOrden(OrderDTO orderDTO);
		

}
