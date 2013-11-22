package com.kallSonys.business.transformation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.kallSonys.business.consts.CustomerConsts;
import com.kallSonys.business.dto.AddressDTO;
import com.kallSonys.business.dto.CustomerDTO;
import com.kallSonys.business.dto.ItemDTO;
import com.kallSonys.business.dto.OrderDTO;
import com.kallSonys.common.dal.jpa.entitys.Address;
import com.kallSonys.common.dal.jpa.entitys.Customer;
import com.kallSonys.common.dal.jpa.entitys.CustomerAddress;
import com.kallSonys.common.dal.jpa.entitys.Item;
import com.kallSonys.common.dal.jpa.entitys.Orders;

public class PersistenceConverter {

	
	private static Long totalOrder = new Long(0);
 	
	//Convertir orderDTO to OrderEntityBD
	public static Orders order_DtoToEntityBD(OrderDTO orderDTO)
	{	
		Orders orders = new Orders();
		orders.setComments(orderDTO.getCOMMENTS());
		orders.setOrderdate(orderDTO.getORDERDATE());
		orders.setPrice(orderDTO.getPRICE());
		orders.setStatus(orderDTO.getSTATUS());
		
		//Elementos relacionados
		orders.setCustomer(customer_DtoToEntityBD(orderDTO.getCustomerDTO()));		
		orders.setItems(item_DtoToEntityBD(orderDTO.getListadoItemsDTO(),orders));
		orders.setPrice(new BigDecimal(totalOrder));
		//Retornamos la orden completa
		return orders;
	}
        
    	
	//Convertir CustomerDTO to CustomerEntityBD
	//No setea los objetos relacionados por que el objeto principal que
	//crea en cascada es el objeto customerAddress
	public static Customer customer_DtoToEntityBD(CustomerDTO customerDTO)
	{
		Customer customer=new Customer();
		customer.setCustid(customerDTO.getIdCliente());
		customer.setFname(customerDTO.getNombreCliente());
		customer.setLname(customerDTO.getApellidoCliente());
		customer.setPhonenumber(customerDTO.getNumeroTelefonico());
		customer.setEmail(customerDTO.getEmail());
		if(customerDTO.getTipoTarjetaCredito()!=null)
		{
			customer.setCreditcardtype(customerDTO.getTipoTarjetaCredito().getIdTipoTarjeta());
		}						
		customer.setCreditcardnumer(customerDTO.getNumeroTarjetaCredito());
		customer.setStatus("NA");//No existe en el objeto DTO
		//customer.setCustomertype(null); //Este objeto se setea en CustomerServiceBean
		customer.setPasswordd(customerDTO.getPassword());								
		return customer;
	}
	
  
	
	//Convierte el objeto DTO a Entity
	public static List<Address> Address_DtoToEntityBD(List<AddressDTO> listadoAddresDTO)
	{
		List<Address> listadoAddress = new ArrayList<Address>();				
	    for (AddressDTO itemAddressDto : listadoAddresDTO) 
	    {
	    	Address itemAddress = new Address();
	    	//itemAddress.setAddrid(null); // Se crea dinámincamente
	    	itemAddress.setStreet(itemAddressDto.getSTREET());
	    	itemAddress.setState(itemAddressDto.getSTATE());
	    	itemAddress.setZip(itemAddressDto.getZIP());
	    	itemAddress.setCountry(itemAddressDto.getCOUNTRY());
	    	itemAddress.setAddresstype(itemAddressDto.getADDRESSTYPE());
	    	itemAddress.setCity(itemAddressDto.getCITY());	    	
	    	listadoAddress.add(itemAddress);
		}			   				
		return listadoAddress;	
	}
	
	//Convertir CustomerDTO to CustomerEntityBD
	public static Set<Item> item_DtoToEntityBD(List<ItemDTO> itemDTO,Orders orders)
	{
		Set<Item> setItems = new HashSet<Item>();				
	    for (ItemDTO itemDto : itemDTO) 
	    {
	    	Item item = new Item();
	    	item.setProdid(itemDto.getPRODID());
	    	item.setProductname(itemDto.getPRODUCTNAME());
	    	item.setPartnum(itemDto.getPARTNUM());
	    	item.setPrice(itemDto.getPRICE());
	    	item.setQuantity(itemDto.getQUANTITY());
	    	item.setOrder(orders);
	    	setItems.add(item);
	    	//Onteniendo sumatoria de las ordenes
	    	totalOrder += ((itemDto.getPRICE().longValue()) * (itemDto.getQUANTITY().longValue()));
		}			   				
		return setItems;
	}	        

}
