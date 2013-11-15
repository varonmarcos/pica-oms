/**
 * 
 */
package com.kallSonys.business.Imple;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import com.kallSonys.business.Interfaces.LoginServiceLocal;
import com.kallSonys.business.dto.UserDTO;
import com.kallSonys.seg.biz.ldap.facade.LdapFacade;
import com.kallSonys.seg.biz.transfer.user.UsersDTO;


/**
 * @author Juan Pablo Aranda
 *
 */
@Stateless(name="LoginServiceBean", mappedName = "LoginServiceBean")
@Local(LoginServiceLocal.class)
public class LoginServiceBean implements LoginServiceLocal {

	
	@EJB (mappedName="LdapBean")
	private LdapFacade ldapFacadeBean;
	
	/* (non-Javadoc)
	 * @see com.kallSonys.business.Interfaces.LoginServiceLocal#login(com.kallSonys.seg.biz.transfer.user.UsersDTO)
	 */
	@Override 
	public Boolean login(UserDTO user) {
		
		UsersDTO usersDTO=new UsersDTO();
		usersDTO.setUser(user.getUser());
		usersDTO.setPass(user.getPassword());
		
		usersDTO=ldapFacadeBean.connect(usersDTO);
		if(usersDTO.isAutenticado()){
			return Boolean.TRUE;
		}
		
		return Boolean.FALSE;
	}

}
