package com.kallSonys.seg.biz.transfer.app;

import java.io.Serializable;

public class AppRecursosDto implements Serializable{

		
	
	private static final long serialVersionUID = 1L;
	private long idrecursos;
	private String nombre;
	
	
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
