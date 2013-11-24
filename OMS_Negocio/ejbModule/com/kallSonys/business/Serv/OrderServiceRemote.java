/**
 * 
 */
package com.kallSonys.business.Serv;

import java.util.List;

import javax.ejb.Remote;

import com.kallSonys.business.dto.OrderDTO;
import com.kallSonys.common.dal.jpa.entitys.Orders;

 
/**
 * @author Frank Arregocés Rodríguez
 *
 */
@Remote
public interface OrderServiceRemote {
	
	public String crearOrden(OrderDTO orderDTO);
	
	public List<Orders> getOrderByCustomer (String customerID);
		

}
