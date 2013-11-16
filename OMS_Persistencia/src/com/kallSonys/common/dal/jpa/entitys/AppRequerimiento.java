package com.kallSonys.common.dal.jpa.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the APP_REQUERIMIENTO database table.
 * 
 */
@Entity
@Table(name="APP_REQUERIMIENTO")
public class AppRequerimiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idrequerimiento;

	private String code;

	private String descripcion;

	//bi-directional many-to-many association to AppRecurso
    @ManyToMany
	@JoinTable(
		name="APP_RECUSOSXREQUERIMIENTO"
		, joinColumns={
			@JoinColumn(name="IDREQUERIMIENTO")
			}
		, inverseJoinColumns={
			@JoinColumn(name="IDRECURSO")
			}
		)
	private Set<AppRecurso> appRecursos;

	//bi-directional many-to-many association to AppRol
    @ManyToMany
	@JoinTable(
		name="APP_ROLESXREQUERIMIENTO"
		, joinColumns={
			@JoinColumn(name="IDREQUERIMIENTO")
			}
		, inverseJoinColumns={
			@JoinColumn(name="CODEROL")
			}
		)
	private Set<AppRol> appRols;

    public AppRequerimiento() {
    }

	public long getIdrequerimiento() {
		return this.idrequerimiento;
	}

	public void setIdrequerimiento(long idrequerimiento) {
		this.idrequerimiento = idrequerimiento;
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

	public Set<AppRecurso> getAppRecursos() {
		return this.appRecursos;
	}

	public void setAppRecursos(Set<AppRecurso> appRecursos) {
		this.appRecursos = appRecursos;
	}
	
	public Set<AppRol> getAppRols() {
		return this.appRols;
	}

	public void setAppRols(Set<AppRol> appRols) {
		this.appRols = appRols;
	}
	
}