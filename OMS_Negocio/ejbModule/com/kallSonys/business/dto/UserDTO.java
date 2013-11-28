package com.kallSonys.business.dto;

import java.io.Serializable;
import java.util.List;

import com.kallSonys.seg.biz.transfer.app.AppRecursosDto;

public class UserDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String user;
	private String password;
	private String identificacion;
    private String nombre;
    private String apellido;
    private String email;
    private List<AppRecursosDTO> listadoRecursos;
    private boolean autenticado=false;
	
	public UserDTO(){
		
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<AppRecursosDTO> getListadoRecursos() {
		return listadoRecursos;
	}

	public void setListadoRecursos(List<AppRecursosDTO> listadoRecursos) {
		this.listadoRecursos = listadoRecursos;
	}

	public boolean isAutenticado() {
		return autenticado;
	}

	public void setAutenticado(boolean autenticado) {
		this.autenticado = autenticado;
	}
	
	

}
