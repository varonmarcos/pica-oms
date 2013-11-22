/**
 * 
 */
package com.kallSonys.business.Imple;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.kallSonys.business.Serv.CustomerServiceLocal;
import com.kallSonys.business.Serv.OrderServiceLocal;
import com.kallSonys.business.dto.OrdenDTO;
import com.kallSonys.common.dal.jpa.facade.OrdersFacadeLocal;

/**
 * @author Juan Pablo Aranda Galvis
 *
 */

@Stateless(name="OrderServiceBean", mappedName = "OrderServiceBean")
@Remote(OrderServiceLocal.class)
public class OrderServiceBean implements OrderServiceLocal {

	
	@EJB
	private OrdersFacadeLocal orderFacade;
	/* (non-Javadoc)
	 * @see com.kallSonys.business.Serv.OrderServiceLocal#searchOrders()
	 */
	@Override
	public List<OrdenDTO> searchOrders() {
		List<OrdenDTO> listOrdes=new ArrayList<OrdenDTO>();
	
		
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.kallSonys.business.Serv.OrderServiceLocal#deleteOrder(com.kallSonys.business.dto.OrdenDTO)
	 */
	@Override
	public boolean deleteOrder(OrdenDTO order) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.kallSonys.business.Serv.OrderServiceLocal#cancelledOrder(com.kallSonys.business.dto.OrdenDTO)
	 */
	@Override
	public boolean cancelledOrder(OrdenDTO order) {
		// TODO Auto-generated method stub
		return false;
	}

}
