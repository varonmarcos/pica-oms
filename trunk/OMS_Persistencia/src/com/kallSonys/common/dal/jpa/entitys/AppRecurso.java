package com.kallSonys.common.dal.jpa.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the APP_RECURSOS database table.
 * 
 */
@Entity
@Table(name="APP_RECURSOS")
public class AppRecurso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idrecursos;

	private String nombre;

	//bi-directional many-to-many association to AppRequerimiento
	@ManyToMany(mappedBy="appRecursos")
	private Set<AppRequerimiento> appRequerimientos;

    public AppRecurso() {
    }

	public long getIdrecursos() {
		return this.idrecursos;
	}

	public void setIdrecursos(long idrecursos) {
		this.idrecursos = idrecursos;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<AppRequerimiento> getAppRequerimientos() {
		return this.appRequerimientos;
	}

	public void setAppRequerimientos(Set<AppRequerimiento> appRequerimientos) {
		this.appRequerimientos = appRequerimientos;
	}
	
}