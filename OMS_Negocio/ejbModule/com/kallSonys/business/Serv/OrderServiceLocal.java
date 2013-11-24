/**
 * 
 */
package com.kallSonys.business.Serv;

import java.util.List;

import javax.ejb.Remote;

import com.kallSonys.business.dto.OrdenDTO;
import com.kallSonys.business.dto.OrderDTO;
import com.kallSonys.common.dal.jpa.entitys.Orders;

/**
 * @author Juan Pablo Aranda Galvis
 *
 */
@Remote
public interface OrderServiceLocal {
	
	public List<OrdenDTO> searchOrders();
	
	public boolean deleteOrder(OrdenDTO order);
	
	public boolean cancelledOrder(OrdenDTO order);

	public String crearOrden(OrderDTO orderDTO);
	
	public List<Orders> getOrderByCustomer (String customerID);
	
	public String cambiarEstadoOrden(OrderDTO orderDTO) ;
	
}
