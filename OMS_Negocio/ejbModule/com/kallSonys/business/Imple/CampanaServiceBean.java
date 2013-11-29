package com.kallSonys.business.Imple;

import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.kallSonys.business.Serv.CampanaServiceLocal;
import com.kallSonys.business.Serv.CustomerServiceLocal;
import com.kallSonys.business.consts.CustomerConsts;
import com.kallSonys.business.dto.CampanaDTO;
import com.kallSonys.business.dto.CustomerDTO;
import com.kallSonys.business.enums.enumCustomerType;
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
@Stateless(name = "CampanaServiceBean", mappedName = "CampanaServiceBean")
@Remote(CampanaServiceLocal.class)
public class CampanaServiceBean implements CampanaServiceLocal {

	
	
	
	@Override
	public void createCampana(CampanaDTO campanaDto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifiedCampana(CampanaDTO campanaDto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletedCampana(CampanaDTO campanaDto) {
		// TODO Auto-generated method stub
		
	}

	
}
