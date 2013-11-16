package com.kallSonys.common.dal.jpa.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the APP_ROL database table.
 * 
 */
@Entity
@Table(name="APP_ROL")
public class AppRol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String code;

	private String descripcion;

	//bi-directional many-to-many association to AppRequerimiento
	@ManyToMany(mappedBy="appRols")
	private Set<AppRequerimiento> appRequerimientos;

	//bi-directional many-to-one association to AppUsuariosxrol
	@OneToMany(mappedBy="appRol")
	private Set<AppUsuariosxrol> appUsuariosxrols;

    public AppRol() {
    }

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set<AppRequerimiento> getAppRequerimientos() {
		return this.appRequerimientos;
	}

	public void setAppRequerimientos(Set<AppRequerimiento> appRequerimientos) {
		this.appRequerimientos = appRequerimientos;
	}
	
	public Set<AppUsuariosxrol> getAppUsuariosxrols() {
		return this.appUsuariosxrols;
	}

	public void setAppUsuariosxrols(Set<AppUsuariosxrol> appUsuariosxrols) {
		this.appUsuariosxrols = appUsuariosxrols;
	}
	
}