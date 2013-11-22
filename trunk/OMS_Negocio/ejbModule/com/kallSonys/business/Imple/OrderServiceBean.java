package com.kallSonys.business.Imple;

import java.util.Calendar;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.kallSonys.business.Serv.OrderServiceRemote;
import com.kallSonys.business.consts.CustomerConsts;
import com.kallSonys.business.dto.OrderDTO;
import com.kallSonys.business.transformation.PersistenceConverter;
import com.kallSonys.common.dal.jpa.entitys.Orders;
import com.kallSonys.common.dal.jpa.facade.OrdersFacadeLocal;

/**
 * @author Frank Arregocés Rodríguez
 *
 */
@Stateless(name="OrderServiceBean", mappedName = "OrderServiceBean")
@Remote(OrderServiceRemote.class)
public class OrderServiceBean implements OrderServiceRemote {

	@EJB(mappedName="OrdersFacadeBean")
	private OrdersFacadeLocal orderBean;	
	
	
	@Override
	public String crearOrden(OrderDTO orderDTO) 
	{
		System.out.println("OrderServiceBean crearOrden 1");		
		orderDTO.setORDERDATE(Calendar.getInstance().getTime());		
		orderDTO.setSTATUS(CustomerConsts.STATUS_ORDER_INICIADA);						
		return orderBean.createAndReturnID(PersistenceConverter.order_DtoToEntityBD(orderDTO));	    
	}
		
}
