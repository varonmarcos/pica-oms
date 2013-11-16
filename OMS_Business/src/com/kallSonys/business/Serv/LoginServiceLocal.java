/**
 * 
 */
package com.kallSonys.business.Serv;

import javax.ejb.Remote;

import com.kallSonys.business.dto.UserDTO;
import com.kallSonys.seg.biz.transfer.user.UsersAuthenticatedDTO;


/**
 * @author Juan Pablo Aranda Galvis
 *
 */
@Remote
public interface LoginServiceLocal {
	
	public UsersAuthenticatedDTO login(UserDTO user);

}
