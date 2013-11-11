package com.kallSonys.seg.biz.ldap.facade;

import com.kallSonys.seg.biz.transfer.user.UsersDTO;

import javax.ejb.Remote;
import javax.naming.directory.Attribute;


@Remote
public interface LdapFacade {
 
	
	  public UsersDTO connect(UsersDTO usersDTO);
	  	  	  
	  public Attribute cargarPropiedadConexion(String atributo);
	  	 
}
