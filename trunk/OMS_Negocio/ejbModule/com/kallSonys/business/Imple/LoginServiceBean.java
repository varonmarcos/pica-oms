/**
 * 
 */
package com.kallSonys.business.Imple;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.kallSonys.business.Serv.LoginServiceLocal;
import com.kallSonys.business.dto.UserDTO;
import com.kallSonys.common.dal.jpa.entitys.AppRecurso;
import com.kallSonys.common.dal.jpa.facade.appSeg.AppRecursosFacadeRemote;
import com.kallSonys.seg.biz.ldap.facade.LdapFacade;
import com.kallSonys.seg.biz.transfer.app.AppRecursosDto;
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
	LdapFacade ldapFacadeBean;
	@EJB (mappedName="AppRecursosBean")
	AppRecursosFacadeRemote AppRecursosFacadeBean;
	
	/* (non-Javadoc)
	 * @see com.kallSonys.business.Interfaces.LoginServiceLocal#login(com.kallSonys.seg.biz.transfer.user.UsersDTO)
	 */
	@Override 
	public UserDTO login(UserDTO user) {
		
		//Informacion usuario en session
		
		UsersAuthenticatedDTO usuarioAutenticado = new  UsersAuthenticatedDTO();
		UsersDTO usersDTO=new UsersDTO();
		usersDTO.setUser(user.getUser());
		usersDTO.setPass(user.getPassword());
		
		usuarioAutenticado = ldapFacadeBean.connect(usersDTO);
		if(usuarioAutenticado.isAutenticado()){
			
			//email para pruebas: frankr1383@gmail.com
			List<AppRecurso> setRecursos = AppRecursosFacadeBean.findRecursosByUser(usuarioAutenticado.getEmail().trim());
			List<AppRecursosDto> setRecursosDTO = new ArrayList<AppRecursosDto>();			
			if(setRecursos!=null && setRecursos.size()>0)
			{										
				System.out.println("Se obtuvieron recursos: "+setRecursos.size());
				for(int i=0;i<setRecursos.size(); i++)
				{
					AppRecursosDto recursosDTO = new AppRecursosDto();
					recursosDTO.setIdrecursos(+setRecursos.get(i).getIdrecursos());
					recursosDTO.setNombre(setRecursos.get(i).getNombre());
					setRecursosDTO.add(recursosDTO);
				}
				usuarioAutenticado.setListadoRecursos(setRecursosDTO);
				user=this.convertUser(usuarioAutenticado);
			}
			else 
			{
				System.out.println("No se encontraron recursos con permisos asociados para el usuario: frankr1383@gmail.com");
			}
			return user;
		}
		else
		{	      
			return null;
		}
	}
	
	private UserDTO convertUser(UsersAuthenticatedDTO userAut){
		
		UserDTO user=new UserDTO();
		user.setNombre(userAut.getNombre());
		user.setApellido(userAut.getApellido());
		user.setAutenticado(userAut.isAutenticado());
		user.setListadoRecursos(userAut.getListadoRecursos());
		
		return user;
		
	}

}
