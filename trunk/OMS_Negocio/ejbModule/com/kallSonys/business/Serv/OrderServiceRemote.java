/**
 * 
 */
package com.kallSonys.business.Serv;

import javax.ejb.Remote;

import com.kallSonys.business.dto.OrderDTO;

 
/**
 * @author Frank Arregoc�s Rodr�guez
 *
 */
@Remote
public interface OrderServiceRemote {
	
	public String crearOrden(OrderDTO orderDTO);
		

}
