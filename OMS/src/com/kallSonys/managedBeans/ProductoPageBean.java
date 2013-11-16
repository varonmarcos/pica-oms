package com.kallSonys.managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

import com.kallSonys.business.dto.CategoriaProductoDTO;
import com.kallSonys.business.dto.ProductoDTO;
import com.kallSonys.business.dto.TipoTarjetaCreditoDTO;
import com.kallSonys.web.util.SelectItemUtils;

/**
 * 
 * @author juanaranda
 *
 */
@ManagedBean(name="productoPageBean")
@RequestScoped
public class ProductoPageBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<SelectItem> listProductCategory;
	private String categoriaSelected;
	private ProductoDTO productoDTO;
	
	
	public ProductoPageBean(){
		setUpPrerender();
		
	}
	
	private void setUpPrerender(){
		this.loadSelectItemCategoryProduct();
	}
	
	

	private void loadSelectItemCategoryProduct(){
		List<CategoriaProductoDTO> categorias=CategoriaProductoDTO.preloadData();
		try {
			this.listProductCategory=SelectItemUtils.buildSelectItems(categorias, "idTipoTarjeta", "nombreTipoTarjeta", true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ProductoDTO getProductoDTO() {
		return productoDTO;
	}

	public void setProductoDTO(ProductoDTO productoDTO) {
		this.productoDTO = productoDTO;
	}


	public List<SelectItem> getListProductCategory() {
		return listProductCategory;
	}


	public void setListProductCategory(List<SelectItem> listProductCategory) {
		this.listProductCategory = listProductCategory;
	}


	public String getCategoriaSelected() {
		return categoriaSelected;
	}


	public void setCategoriaSelected(String categoriaSelected) {
		this.categoriaSelected = categoriaSelected;
	}
	
	
	

}
