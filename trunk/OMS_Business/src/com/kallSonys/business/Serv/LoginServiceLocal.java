/**
 * 
 */
package com.kallSonys.business.Serv;

import javax.ejb.Local;

import com.kallSonys.business.dto.UserDTO;


/**
 * @author Juan Pablo Aranda Galvis
 *
 */
@Local
public interface LoginServiceLocal {
	
	public Boolean login(UserDTO user);

}
