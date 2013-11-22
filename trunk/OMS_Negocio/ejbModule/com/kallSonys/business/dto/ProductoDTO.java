package com.kallSonys.business.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 * @author Juan Pablo Aranda Galvis
 *
 */
public class ProductoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Long productoId;
	private String name;
	private String descripcion;
	private CategoriaProductoDTO categoria;
	private BigDecimal listaPrecio;
	private String partnum;
	private String productor;//Sony-RapidService
	private byte[] imagen;
	private String imagenUrl;
	
	public ProductoDTO(){
		
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

	public CategoriaProductoDTO getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaProductoDTO categoria) {
		this.categoria = categoria;
	}

	public BigDecimal getListaPrecio() {
		return listaPrecio;
	}

	public void setListaPrecio(BigDecimal listaPrecio) {
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

	public String getPartnum() {
		return partnum;
	}

	public void setPartnum(String partnum) {
		this.partnum = partnum;
	}
	
	

}
