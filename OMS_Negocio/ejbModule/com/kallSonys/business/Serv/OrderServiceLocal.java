/**
 * 
 */
package com.kallSonys.business.Serv;

import java.util.List;

import javax.ejb.Remote;

import com.kallSonys.business.dto.OrdenDTO;

/**
 * @author Juan Pablo Aranda Galvis
 *
 */
@Remote
public interface OrderServiceLocal {
	
	public List<OrdenDTO> searchOrders();
	
	public boolean deleteOrder(OrdenDTO order);
	
	public boolean cancelledOrder(OrdenDTO order);

}
