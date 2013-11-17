package com.kallSonys.seg.biz.ldap.facade;

import com.kallSonys.seg.biz.transfer.user.UsersAuthenticatedDTO;
import com.kallSonys.seg.biz.transfer.user.UsersDTO;

import javax.ejb.Remote;
import javax.naming.directory.Attribute;


@Remote
public interface LdapFacade {
 
	
	  public UsersAuthenticatedDTO connect(UsersDTO usersDTO);
	  	 
}
