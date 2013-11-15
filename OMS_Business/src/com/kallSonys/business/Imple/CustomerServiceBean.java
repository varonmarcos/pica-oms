/**
 * 
 */
package com.kallSonys.business.Imple;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import com.kallSonys.business.Serv.CustomerServiceLocal;
import com.kallSonys.business.consts.CustomerConsts;
import com.kallSonys.business.dto.CustomerDTO;
import com.kallSonys.common.dal.jpa.entitys.Customer;
import com.kallSonys.common.dal.jpa.entitys.Customertype;
import com.kallSonys.common.dal.jpa.facade.CustomerFacadeLocal;
import com.kallSonys.common.dal.jpa.facade.CustomertypeFacadeLocal;

/**
 * @author Juan Pablo Aranda Galvis
 *
 */
@Stateless(name="CustomerServiceBean", mappedName = "CustomerServiceBean")
@Local(CustomerServiceLocal.class)
public class CustomerServiceBean implements CustomerServiceLocal {

	@EJB
	private CustomerFacadeLocal customerFacade;
	@EJB
	private CustomertypeFacadeLocal customerTypeFacade;
	
	/* (non-Javadoc)
	 * @see com.kallSonys.business.Interfaces.CustomerServicesLocal#createCustomer(com.kallSonys.common.dal.jpa.entitys.Customer)
	 */
	@Override
	public Boolean createCustomer(CustomerDTO customerDTO) {
		
		Boolean res=Boolean.FALSE;
		if(customerFacade.createAndConfirm(this.convertCustomerWebToDB(customerDTO))){
			return Boolean.TRUE;
		}
		return res;
	}

	/* (non-Javadoc)
	 * @see com.kallSonys.business.Interfaces.CustomerServicesLocal#getCustomers()
	 */
	@Override
	public CustomerDTO getCustomers() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Customer convertCustomerWebToDB(CustomerDTO customerDTO){
		Customer cus=new Customer();
		cus.setCustid(customerDTO.getIdCliente());
		cus.setFname(customerDTO.getNombreCliente());
		cus.setLname(customerDTO.getApellidoCliente());
		cus.setEmail(customerDTO.getEmail());
		cus.setCreditcardtype(customerDTO.getTipoTarjetaCredito().getIdTipoTarjeta());
		cus.setCreditcardnumer(customerDTO.getNumeroTarjetaCredito());
		cus.setPasswordd(customerDTO.getPassword());
		cus.setCustomertype(this.getDefaultCustomerType());
		return cus;
	}
	
		private Customertype getDefaultCustomerType(){
		Customertype customertype=customerTypeFacade.find(CustomerConsts.CUSTOMER_TYPE_DEFAULT);
		return customertype;
	}

}
