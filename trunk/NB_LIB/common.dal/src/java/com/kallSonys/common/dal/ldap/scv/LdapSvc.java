package com.kallSonys.common.dal.ldap.scv;

import com.kallSonys.seg.biz.transfer.UsersDTO;

import javax.ejb.Remote;
import javax.naming.directory.Attribute;


@Remote
public interface LdapSvc {
 
	
	  public UsersDTO connect(UsersDTO usersDTO);
	  	  	  
	  public Attribute cargarPropiedadConexion(String atributo);
	  	 
}
