/**
 * 
 */
package com.kallSonys.business.Imple;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.kallSonys.business.Serv.LoginServiceLocal;
import com.kallSonys.business.dto.UserDTO;
import com.kallSonys.common.dal.jpa.facade.appSeg.AppRecursosFacadeRemote;
import com.kallSonys.seg.biz.ldap.facade.LdapFacade;
import com.kallSonys.seg.biz.transfer.user.UsersAuthenticatedDTO;
import com.kallSonys.seg.biz.transfer.user.UsersDTO;


/**
 * @author Juan Pablo Aranda
 *
 */
@Stateless(name="LoginServiceBean", mappedName = "LoginServiceBean")
@Remote(LoginServiceLocal.class)
public class LoginServiceBean implements LoginServiceLocal {

	
	@EJB (mappedName="LdapBean")
	private LdapFacade ldapFacadeBean;
	@EJB (mappedName="AppRecursosBean")
	AppRecursosFacadeRemote AppRecursosFacadeBean;
	
	/* (non-Javadoc)
	 * @see com.kallSonys.business.Interfaces.LoginServiceLocal#login(com.kallSonys.seg.biz.transfer.user.UsersDTO)
	 */
	@Override 
	public UsersAuthenticatedDTO login(UserDTO user) {
		
		//Informacion usuario en session		
		UsersAuthenticatedDTO usuarioAutenticado = new  UsersAuthenticatedDTO();
		UsersDTO usersDTO=new UsersDTO();
		usersDTO.setUser(user.getUser());
		usersDTO.setPass(user.getPassword());
		
		usuarioAutenticado = ldapFacadeBean.connect(usersDTO);
		if(usuarioAutenticado.isAutenticado()){
			return usuarioAutenticado;
		}
		else
		{	      
			return null;
		}
	}

}
