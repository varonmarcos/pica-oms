package com.kallSonys.seg.biz.ldap.transfer;

import java.io.Serializable;

public class LdapConnectionDTO implements Serializable {

	
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
        public String servidor;
        public String usuario;
        public String clave;      
        public String dn;
        public String tipoAuth;
    
    
	public String getServidor() {
		return servidor;
	}
	public void setServidor(String servidor) {
		this.servidor = servidor;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getDn() {
		return dn;
	}
	public void setDn(String dn) {
		this.dn = dn;
	}
	public String getTipoAuth() {
		return tipoAuth;
	}
	public void setTipoAuth(String tipoAuth) {
		this.tipoAuth = tipoAuth;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}  
	
}
