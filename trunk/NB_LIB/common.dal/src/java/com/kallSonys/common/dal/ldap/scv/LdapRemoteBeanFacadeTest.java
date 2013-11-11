package com.kallSonys.common.dal.ldap.scv;

import javax.ejb.Remote;


@Remote
public interface LdapRemoteBeanFacadeTest {
 
	
	  public String connect();
	  	  	  
	  public String operacion(int a, int b);
	  	 
}
