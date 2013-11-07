package com.kallSonys.web.vo;

import java.io.Serializable;

/**
 * 
 * @author Juan Pablo Aranda Galvis
 * Esta clase representa las Categorias de los productos
 */
public class CategoriaProductoVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String idCategoria;
	private String nameCategoria;
	
	public CategoriaProductoVO(){
		
	}

	public String getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(String idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNameCategoria() {
		return nameCategoria;
	}

	public void setNameCategoria(String nameCategoria) {
		this.nameCategoria = nameCategoria;
	}
	
	

}
