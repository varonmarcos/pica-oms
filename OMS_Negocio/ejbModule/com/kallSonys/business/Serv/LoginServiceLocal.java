/**
 * 
 */
package com.kallSonys.business.Serv;

import javax.ejb.Remote;

import com.kallSonys.business.dto.UserDTO;

 
/**
 * @author Juan Pablo Aranda Galvis
 *
 */
@Remote
public interface LoginServiceLocal {
	
	public UserDTO login(UserDTO user);

}
