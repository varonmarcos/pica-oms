package com.kallSonys.common.dal.jpa.entitys;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the APP_USUARIOSXROL database table.
 * 
 */
@Embeddable
public class AppUsuariosxrolPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="EMAIL_USUARIO")
	private String emailUsuario;

	private String coderol;

    public AppUsuariosxrolPK() {
    }
	public String getEmailUsuario() {
		return this.emailUsuario;
	}
	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}
	public String getCoderol() {
		return this.coderol;
	}
	public void setCoderol(String coderol) {
		this.coderol = coderol;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AppUsuariosxrolPK)) {
			return false;
		}
		AppUsuariosxrolPK castOther = (AppUsuariosxrolPK)other;
		return 
			this.emailUsuario.equals(castOther.emailUsuario)
			&& this.coderol.equals(castOther.coderol);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.emailUsuario.hashCode();
		hash = hash * prime + this.coderol.hashCode();
		
		return hash;
    }
}