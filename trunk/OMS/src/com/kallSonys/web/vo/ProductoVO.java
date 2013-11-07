package com.kallSonys.web.vo;

import java.io.Serializable;

/**
 * 
 * @author Juan Pablo Aranda Galvis
 *
 */
public class ProductoVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Long productoId;
	private String name;
	private String descripcion;
	private CategoriaProductoVO categoria;
	private double listaPrecio;
	private String productor;//Sony-RapidService
	private byte[] imagen;
	private String imagenUrl;
	
	public ProductoVO(){
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProductoId() {
		return productoId;
	}

	public void setProductoId(Long productoId) {
		this.productoId = productoId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public CategoriaProductoVO getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaProductoVO categoria) {
		this.categoria = categoria;
	}

	public double getListaPrecio() {
		return listaPrecio;
	}

	public void setListaPrecio(double listaPrecio) {
		this.listaPrecio = listaPrecio;
	}

	public String getProductor() {
		return productor;
	}

	public void setProductor(String productor) {
		this.productor = productor;
	}

	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	public String getImagenUrl() {
		return imagenUrl;
	}

	public void setImagenUrl(String imagenUrl) {
		this.imagenUrl = imagenUrl;
	}
	
	


}
