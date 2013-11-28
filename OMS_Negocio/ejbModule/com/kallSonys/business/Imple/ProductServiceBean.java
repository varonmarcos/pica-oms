/**
 * 
 */
package com.kallSonys.business.Imple;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.kallSonys.business.Serv.ProductServiceLocal;
import com.kallSonys.business.dto.ProductoDTO;
import com.kallSonys.common.dal.jpa.entitys.Item;
import com.kallSonys.common.dal.jpa.facade.ItemsFacadeLocal;

/**
 * @author Juan Pablo Aranda Galvis
 *
 */
@Stateless(name="ProductServiceBean", mappedName = "ProductServiceBean")
@Remote(ProductServiceLocal.class)
public class ProductServiceBean implements ProductServiceLocal {

	 @EJB
	 private ItemsFacadeLocal itemFacade;
	
	
	
	@Override
	public ProductoDTO getProductByCode(String producId) {
		//Aca debemos conectarnos al WS de B2C
		return null;
	}

	@Override
	public List<ProductoDTO> getProductsByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductoDTO> getProductsByWildcardsName(String willCardName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductoDTO> getProductByWildcardsDesc(String willCardDesc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductoDTO> getProductBestSeller(Date fechaInicio,
			Date fechaFin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean createPrduct(ProductoDTO product) {
		
		Boolean response=Boolean.FALSE;
		try{
		//response=itemFacade.createAndConfirm(product);
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public boolean modifiedProduct(ProductoDTO producto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteProduct(ProductoDTO producto) {
		// TODO Auto-generated method stub
		return false;
	}

	
	

}
