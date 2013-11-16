package com.kallSonys.business.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Juan Pablo Aranda Galvis
 * Esta clase representa las Categorias de los productos
 */
public class CategoriaProductoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String idCategoria;
	private String nameCategoria;
	
	/**
	 * Minimal constructor
	 */
	public CategoriaProductoDTO(){
		
	}
	
	public CategoriaProductoDTO(String idCategoria,String nameCategoria){
		this.idCategoria=idCategoria;
		this.nameCategoria=nameCategoria;
		
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
	
	public static List<CategoriaProductoDTO> preloadData(){
		List<CategoriaProductoDTO> listadoTarjetas=new ArrayList<CategoriaProductoDTO>();
		CategoriaProductoDTO tv=new CategoriaProductoDTO("1","Televisores");
		CategoriaProductoDTO pc=new CategoriaProductoDTO("2","Computadores");
		listadoTarjetas.add(tv);
		listadoTarjetas.add(pc);		
		return listadoTarjetas;
		
	}
	

}
