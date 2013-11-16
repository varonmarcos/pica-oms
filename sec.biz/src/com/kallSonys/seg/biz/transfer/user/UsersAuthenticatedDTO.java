package com.kallSonys.seg.biz.transfer.user;

import java.io.Serializable;
import java.util.List;

import com.kallSonys.seg.biz.transfer.app.AppRecursosDto;


public class UsersAuthenticatedDTO implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String identificacion;
    private String nombre;
    private String apellido;
    private String email;
    private List<AppRecursosDto> listadoRecursos;
    private boolean autenticado=false;

    /**
     * @return the identificacion
     */
    public String getIdentificacion() {
        return identificacion;
    }

    /**
     * @param identificacion the identificacion to set
     */
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

	public boolean isAutenticado() {
		return autenticado;
	}

	public void setAutenticado(boolean autenticado) {
		this.autenticado = autenticado;
	}

	public List<AppRecursosDto> getListadoRecursos() {
		return listadoRecursos;
	}

	public void setListadoRecursos(List<AppRecursosDto> listadoRecursos) {
		this.listadoRecursos = listadoRecursos;
	}
	
	
}
