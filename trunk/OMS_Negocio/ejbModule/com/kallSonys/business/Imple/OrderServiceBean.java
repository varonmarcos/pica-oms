/**
 * 
 */
package com.kallSonys.business.Imple;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.kallSonys.business.Serv.OrderServiceLocal;
import com.kallSonys.business.consts.OrderConst;
import com.kallSonys.business.dto.OrdenDTO;
import com.kallSonys.business.dto.OrderDTO;
import com.kallSonys.business.transformation.PersistenceConverter;
import com.kallSonys.common.dal.jpa.entitys.Orders;
import com.kallSonys.common.dal.jpa.facade.OrdersFacadeLocal;

/**
 * @author Juan Pablo Aranda Galvis
 *
 */

@Stateless(name="OrderServiceBean", mappedName = "OrderServiceBean")
@Remote(OrderServiceLocal.class)
public class OrderServiceBean implements OrderServiceLocal {

	
	@EJB(mappedName="OrdersFacadeBean")
	private OrdersFacadeLocal orderBean;	
	
	
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
	
	
	@Override
	public String crearOrden(OrderDTO orderDTO) 
	{
		System.out.println("OrderServiceBean crearOrden 1");		
		orderDTO.setORDERDATE(Calendar.getInstance().getTime());		
		orderDTO.setSTATUS(OrderConst.ORDER_STATUS_ACTIVO);						
		return orderBean.createAndReturnID(PersistenceConverter.order_DtoToEntityBD(orderDTO));	    
	}


	@Override
	public List<Orders> getOrderByCustomer(String customerID) 
	{
		System.out.println("OrderServiceBean getOrderByCustomer 1");
		return orderBean.getOrderByCustomer(customerID);
	}

	@Override
	public String cambiarEstadoOrden(OrderDTO orderDTO) 
	{
		System.out.println("OrderServiceBean cambiarEstadoOrden: 1: "+orderDTO.getORDERID()+"-"+orderDTO.getSTATUS());
		return orderBean.actualizarEstadoOrden(orderDTO.getORDERID(), orderDTO.getSTATUS());
	}

	@Override
	public List<Orders> getDetallesOrder(String orderID) 
	{
		System.out.println("OrderServiceBean getDetallesOrder: ORDERID: "+orderID);
		return orderBean.getDetallesOrder(orderID);
	}

}
