/**
 * 
 */
package com.kallSonys.business.dto;

import java.io.Serializable;

/**
 * @author Juan Pablo Aranda 
 *
 */
public class AppRecursosDTO implements Serializable{
	
	private long idrecursos;
	private String nombre;
	
	public AppRecursosDTO(){
		
	}

	public long getIdrecursos() {
		return idrecursos;
	}

	public void setIdrecursos(long idrecursos) {
		this.idrecursos = idrecursos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

}
