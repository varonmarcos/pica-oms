package com.kallSonys.common.dal.ldap.mnr;


import javax.naming.directory.Attribute;
import javax.naming.directory.DirContext;
import com.kallSonys.common.dal.ldap.ejb.LdapBean;
import com.kallSonys.common.dal.ldap.scv.LdapSvc;
import com.kallSonys.common.dal.ldap.transfer.LdapConnectionDTO;
import com.kallSonys.seg.biz.transfer.UsersDTO;


public class LdapManager  implements LdapSvc{


     DirContext dc;
     UsersDTO userDTO;
     private LdapConnectionDTO cnDTO;     
     private static final String JDNI_ldapBean = "ldapBean";
     private LdapBean bean = null;
     
     public LdapManager ()
     {
    	 bean = new LdapBean();
     }
     
	
    @Override
    public UsersDTO connect(UsersDTO userDTO) 
    {				  
        return bean.connect(userDTO);  
    }

    @Override
    public Attribute cargarPropiedadConexion(String atributo) 
    {		 
        return null;
    }
	

}
