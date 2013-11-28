/**
 * 
 */
package com.kallSonys.business.dto;

/**
 * @author Juan Pablo Aranda Galvis
 *
 */
public class CampanaDTO {
	
	private String idCampana;
	private String nombreCampana;
	private String idProducto;
	private byte[] imagen;

	public CampanaDTO(){
		
	}

	public String getIdCampana() {
		return idCampana;
	}

	public void setIdCampana(String idCampana) {
		this.idCampana = idCampana;
	}

	public String getNombreCampana() {
		return nombreCampana;
	}

	public void setNombreCampana(String nombreCampana) {
		this.nombreCampana = nombreCampana;
	}

	public String getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}

	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}
	
	
}
