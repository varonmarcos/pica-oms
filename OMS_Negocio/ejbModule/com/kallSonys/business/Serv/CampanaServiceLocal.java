/**;
 * 
 */
package com.kallSonys.business.Serv;

import java.util.Map;

import javax.ejb.Remote;

import com.kallSonys.business.dto.CampanaDTO;
import com.kallSonys.business.dto.CustomerDTO;

/**
 * @author Juan Pablo Aranda Galvis
 *
 */

@Remote
public interface CampanaServiceLocal {
	
	public void createCampana(CampanaDTO campanaDto);
	
	public void modifiedCampana(CampanaDTO campanaDto);
	
	public void deletedCampana(CampanaDTO campanaDto);
	
		

}
