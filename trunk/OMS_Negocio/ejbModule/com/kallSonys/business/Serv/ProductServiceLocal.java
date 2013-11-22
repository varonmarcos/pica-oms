/**
 * 
 */
package com.kallSonys.business.Serv;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import com.kallSonys.business.dto.ProductoDTO;
import com.kallSonys.common.dal.jpa.entitys.Item;

/**
 * @author Juan Pablo Aranda Galvis
 *
 */
@Remote
public interface ProductServiceLocal {
	
	/**
	 * 
	 * @param producId
	 * @return
	 */
	public ProductoDTO getProductByCode(String producId);
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public List<ProductoDTO> getProductsByName(String name);
	
	/**
	 * 
	 * @param willCardName
	 * @return
	 */
	public List<ProductoDTO> getProductsByWildcardsName(String willCardName);
	
	/**
	 * 
	 * @param willCardDesc
	 * @return
	 */
	public List<ProductoDTO> getProductByWildcardsDesc(String willCardDesc);
	
	/**
	 * 
	 * @param fechaInicio
	 * @param fechaFin
	 * @return
	 */
	public List<ProductoDTO> getProductBestSeller(Date fechaInicio,Date fechaFin);
	
	/**
	 * 
	 * @param product
	 * @return
	 */
	public boolean createPrduct(ProductoDTO product);
	
	/**
	 * 
	 * @param producto
	 * @return
	 */
	public boolean modifiedProduct(ProductoDTO producto);
	
	/**
	 * 
	 * @param producto
	 * @return
	 */
	public boolean deleteProduct(ProductoDTO producto);

}
