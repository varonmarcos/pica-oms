/**
 * 
 */
package com.kallSonys.managedBeans;

import javax.ejb.EJB;
import javax.faces.bean.CustomScoped;
import javax.faces.bean.ManagedBean;

import com.kallSonys.business.Imple.CamapanaServiceBean;
import com.kallSonys.business.Serv.CampanaServiceLocal;
import com.kallSonys.business.Serv.CustomerServiceLocal;
import com.kallSonys.business.Serv.ProductServiceLocal;
import com.kallSonys.business.dto.ProductoDTO;

/**
 * @author Juan Pablo Aranda Galvis
 *
 */

@ManagedBean(name="campanasPageBean")
@CustomScoped(value = "#{window}")
public class CampanasPageBean {
	
	@EJB(mappedName="CampanaServiceBean")
	private CampanaServiceLocal campanaServiceFacade;
	@EJB(mappedName="ProductServiceBean")
	private ProductServiceLocal productServiceFacade;
	
	private String idProducto;
	private ProductoDTO productoDTO;
	
	
	public CampanasPageBean(){
		
	}

	/**
	 * Este metodo buscar el producto para el cual
	 * se creara la campaña
	 */
	public void buscarProducto(){
		this.productServiceFacade.getProductByCode(idProducto);
	}

	public String getIdProducto() {
		return idProducto;
	}


	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}


	public CampanaServiceLocal getCampanaServiceFacade() {
		return campanaServiceFacade;
	}


	public void setCampanaServiceFacade(CampanaServiceLocal campanaServiceFacade) {
		this.campanaServiceFacade = campanaServiceFacade;
	}
	
	
	
	

}
