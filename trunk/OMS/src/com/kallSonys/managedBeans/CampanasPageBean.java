/**
 * 
 */
package com.kallSonys.managedBeans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.CustomScoped;
import javax.faces.bean.ManagedBean;

import com.kallSonys.business.Imple.CampanaServiceBean;
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
	private List<ProductoDTO> listProductos;
	private Boolean renderedTablaProducto=Boolean.FALSE;
	private String nombreCampana;
	
	
	
	public Boolean getRenderedTablaProducto() {
		return renderedTablaProducto;
	}

	public void setRenderedTablaProducto(Boolean renderedTablaProducto) {
		this.renderedTablaProducto = renderedTablaProducto;
	}

	public CampanasPageBean(){
		
	}
	
	public void doBuscarProduct(){
		this.listProductos=productServiceFacade.getProductByCode(this.idProducto);
		if(this.listProductos.size()>0){
			this.renderedTablaProducto=Boolean.TRUE;
		}
				
	}
	
	public void doCrearCampaña(){
		
	}

	public ProductServiceLocal getProductServiceFacade() {
		return productServiceFacade;
	}

	public void setProductServiceFacade(ProductServiceLocal productServiceFacade) {
		this.productServiceFacade = productServiceFacade;
	}

	public ProductoDTO getProductoDTO() {
		return productoDTO;
	}

	public void setProductoDTO(ProductoDTO productoDTO) {
		this.productoDTO = productoDTO;
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
	
	public List<ProductoDTO> getListProductos() {
		return listProductos;
	}

	public void setListProductos(List<ProductoDTO> listProductos) {
		this.listProductos = listProductos;
	}

	public String getNombreCampana() {
		return nombreCampana;
	}

	public void setNombreCampana(String nombreCampana) {
		this.nombreCampana = nombreCampana;
	}
	
	

}
