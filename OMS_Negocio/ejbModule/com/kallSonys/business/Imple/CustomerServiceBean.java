package com.kallSonys.business.Imple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.kallSonys.business.Serv.CustomerServiceLocal;
import com.kallSonys.business.consts.CustomerConsts;
import com.kallSonys.business.dto.AddressDTO;
import com.kallSonys.business.dto.CustomerAddressDTO;
import com.kallSonys.business.dto.CustomerDTO;
import com.kallSonys.business.transformation.PersistenceConverter;
import com.kallSonys.common.dal.jpa.entitys.Address;
import com.kallSonys.common.dal.jpa.entitys.Customer;
import com.kallSonys.common.dal.jpa.entitys.CustomerAddress;
import com.kallSonys.common.dal.jpa.entitys.Customertype;
import com.kallSonys.common.dal.jpa.facade.AddressFacadeLocal;
import com.kallSonys.common.dal.jpa.facade.CustomerAddressFacadeLocal;
import com.kallSonys.common.dal.jpa.facade.CustomerFacadeLocal;
import com.kallSonys.common.dal.jpa.facade.CustomertypeFacadeLocal;

/**
 * @author Juan Pablo Aranda Galvis
 *
 */
@Stateless(name="CustomerServiceBean", mappedName = "CustomerServiceBean")
@Remote(CustomerServiceLocal.class)
public class CustomerServiceBean implements CustomerServiceLocal {

	@EJB(mappedName = "CustomerFacadeBean")
	private CustomerFacadeLocal customerBean;
	
	@EJB(mappedName = "CustomertypeFacadeBean")
	private CustomertypeFacadeLocal customerTypeBean;
	
	@EJB (mappedName = "CustomerAddressBean")
	private CustomerAddressFacadeLocal customerAddressBean;
	
	@EJB (mappedName = "AddressFacadeBean")
	private AddressFacadeLocal AddressBean;
	
	
	
	
	@Override
	public String createAndReturnID(CustomerDTO customerDTO) 
	{		
		System.out.println("=======================CUSTOMER SERVICE BEAN================================");        
		//-------------------------------------------------
		//Validamos si el ID del cliente a crear ya existe
		if(customerDTO.getIdCliente()==null)
		{
			return "El ID del cliente a crear es Obligatorio.";
		}
		else if(validarSiClienteExiste(customerDTO.getIdCliente().trim())) 
		{			
			return "El ID del clinte recibido ya existe.";			
		}
					
				
		//--------------------------------------------------------------------------
		//1-Crear el Customer y persistir el Customer		
		boolean isClienteCreado=true;
		Customer customer = PersistenceConverter.customer_DtoToEntityBD(customerDTO);
		customer.setCustomertype(getDefaultCustomerType());
		String idCustomerCreado =  customerBean.createAndReturnID(customer);	
		if(idCustomerCreado==null)
		{
			return null;
		}
		
		//--------------------------------------------------------------------------
	    //2-Crear las direcciones asociadas al cliente
		boolean isListadoDireccionesCreado=true;
		List<Address> listadoAddress = PersistenceConverter.Address_DtoToEntityBD(customerDTO.getListadoAddressDTO());
		String idAddressGenerado="";
		for (int i=0; i< listadoAddress.size(); i++)
	    {	    				
			idAddressGenerado = AddressBean.createAndReturnID(listadoAddress.get(i));					
	    	if(idAddressGenerado != null)
			{				
	    		listadoAddress.get(i).setAddrid(idAddressGenerado);	    		
			}
	    	else
			{
	    		listadoAddress.get(i).setAddrid(null);
	    		isListadoDireccionesCreado = false;	    		
			}			
	    }
	
		
		//Si crearon los objetos bases persistismo el intermedio
		if(isClienteCreado && isListadoDireccionesCreado)
		{
			//--------------------------------------------------------------------------
		    //3-Crear la relacion entre el cliente y la direcccion: CustomerAddress
			boolean isListadoDireccionesPorClienteCreado = true;
			for (int i=0; i< listadoAddress.size(); i++)
			{
				CustomerAddress customerAddress = new CustomerAddress();
				customerAddress.setAddress(listadoAddress.get(i));			
				customerAddress.setCustomer(customer);			
				if(!customerAddressBean.createAndConfirmNative(customerAddress))
				{
					System.out.println("No se logró persistir CustomerAddress "+i);					
					break;
				}else
				{
					System.out.println("Persistencia CustomerAddress OK: "+i+" ID: "+customerAddress.getCustaddid());
				}
			
			}
		}
		else
		{
			//1. Eliminanos el cliente
			customerBean.remove(customer);
			//2 Eliminamos la direcciones
			for (int i=0; i< listadoAddress.size(); i++)
		    {	    												
		    	if(idAddressGenerado != null)
				{						    			    	
		    		AddressBean.remove(listadoAddress.get(i));// hasta el día de hoy todoFirr
				}		    			
		    }
			return null;
		}
					
		return "OK";			
	}
	
	@Override
	public boolean createCustomer(CustomerDTO customerDTO) 
	{	
		return (createAndReturnID(customerDTO) == null) ? false : true;			
	}
	
	@Override
	public CustomerDTO getCustomers() 
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	/*===============================*/
	/*=======METODOS AXULIARES=======*/
	/*===============================*/
	
	private Customertype getDefaultCustomerType()
	{
		System.out.println("CustomerServiceBean getDefaultCustomerType 1");	
		Customertype customertype=customerTypeBean.find(CustomerConsts.CUSTOMER_TYPE_DEFAULT);
		System.out.println("CustomerServiceBean getDefaultCustomerType 2: "+customertype);
		return customertype;
	}

	private boolean validarSiClienteExiste(String idCliente)
	{	
		if(customerBean.find(idCliente) != null) 
		{
			System.out.println("CustomerServiceBean:validarSiClienteExiste");
			return true;			
		}
		return false;
		
	}

	@Override
	public CustomerDTO getCustomerByIdentificador(Map<String,Object> parameters){
		CustomerDTO cusDTO = null;
		Customer customer;
		try {
			//Buscamos por Identificador de Cliente
			customer=this.customerBean.find(parameters.get(CustomerConsts.IDENTIFICACION_FILTER));
			cusDTO=this.convertCustomerBusinessToWeb(customer);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return cusDTO;
	}

	@Override
	public CustomerDTO getCustomerByIdProduct(Map<String, Object> parameters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerDTO getCustomerByIdFacturacion(Map<String, Object> parameters) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private CustomerDTO convertCustomerBusinessToWeb(Customer cus){
		CustomerDTO cusDTO=new CustomerDTO();
		cusDTO.setIdCliente(cus.getCustid());
		cusDTO.setNombreCliente(cus.getFname());
		cusDTO.setApellidoCliente(cus.getLname());
		cusDTO.setEmail(cus.getEmail());
		cusDTO.setTipoTarjetaCredito(cus.getCreditcardtype());
		cusDTO.setNumeroTarjetaCredito(cus.getCreditcardnumer());
		return cusDTO;
	}
}
