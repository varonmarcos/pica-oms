package com.kallSonys.common.dal.jpa.entitys;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the APP_USUARIOSXROL database table.
 * 
 */
@Entity
@Table(name="APP_USUARIOSXROL")
public class AppUsuariosxrol implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AppUsuariosxrolPK id;

	//bi-directional many-to-one association to AppRol
    @ManyToOne
	@JoinColumn(name="CODEROL")
	private AppRol appRol;

    public AppUsuariosxrol() {
    }

	public AppUsuariosxrolPK getId() {
		return this.id;
	}

	public void setId(AppUsuariosxrolPK id) {
		this.id = id;
	}
	
	public AppRol getAppRol() {
		return this.appRol;
	}

	public void setAppRol(AppRol appRol) {
		this.appRol = appRol;
	}
	
}