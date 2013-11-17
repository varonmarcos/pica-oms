/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kallSonys.seg.biz.ldap.ejb;

import com.kallSonys.seg.biz.ldap.facade.LdapFacade;
import com.kallSonys.seg.biz.ldap.transfer.LdapConnectionDTO;
import com.kallSonys.seg.biz.transfer.user.UsersAuthenticatedDTO;
import com.kallSonys.seg.biz.transfer.user.UsersDTO;

import java.io.InputStream;
import java.util.Hashtable;
import java.util.Properties;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

/**
 *
 * @author Frank
 */

@Stateless(name="LdapBean", mappedName = "LdapBean")
@Remote(LdapFacade.class)
public class LdapBean implements LdapFacade {

    private DirContext dc;
	private UsersDTO userDTO;
	private LdapConnectionDTO cnDTO;  
	
	

    @Override
    public UsersAuthenticatedDTO connect(UsersDTO usersDTO)
    {
    	    	       
        if(usersDTO==null)
        {
            System.out.println("EL PARAMETRO RECIBIDO {usersDTO} ES NULL...");
            return null;
        }
        
        //Objeto a devolver
        UsersAuthenticatedDTO usuarioAutenticadoDto = new UsersAuthenticatedDTO();
        this.userDTO = usersDTO;
        
        try 
        {                      
        
        	loadConfigurationConeccion(userDTO);
	        if(cnDTO != null)
	        {
	            Hashtable<Object, Object> env = new Hashtable<Object, Object>();
	            env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
	            env.put(Context.PROVIDER_URL, cnDTO.getServidor());
	            env.put(Context.SECURITY_AUTHENTICATION, cnDTO.getTipoAuth());
	            env.put(Context.SECURITY_PRINCIPAL, cnDTO.getDn());
	            env.put(Context.SECURITY_CREDENTIALS, cnDTO.getClave());
	            dc = new InitialDirContext(env);
	                               	                
                //recuperando una propiedad del LDAP
                //El email es el ID de conexcion entre el LDAP y los permisos
                Attribute atr = cargarPropiedadConexion("mail");
                if(atr!=null)
                {
                	usuarioAutenticadoDto.setEmail(atr.get().toString());
                }
                
                /*
                //Nombre
                atr = cargarPropiedadConexion("nombre");
                if(atr!=null)
                {
                	usuarioAutenticadoDto.setEmail(atr.get().toString());
                }
                //Apellido
                atr = cargarPropiedadConexion("apellido");
                if(atr!=null)
                {
                	usuarioAutenticadoDto.setEmail(atr.get().toString());
                }
                //Identificacion
                atr = cargarPropiedadConexion("identificacion");
                if(atr!=null)
                {
                	usuarioAutenticadoDto.setEmail(atr.get().toString());
                }
               */ 
                usuarioAutenticadoDto.setAutenticado(true);    
		      }
        }
        catch (NamingException ex) 
        {
                System.out.println("ERROR DE AUTENTICACION FRENTE AL LDAP: " + ex.toString());
                usuarioAutenticadoDto.setAutenticado(false);     
                return null;
        }
        
        
      if(!usuarioAutenticadoDto.isAutenticado())
      {
    	  return null;
      }
      
	  return usuarioAutenticadoDto;
    }
	
    
    private Attribute cargarPropiedadConexion(String atributo)
    {
    	 Attribute propiedad = null;
    	 
         try 
         {
             Attributes attrs = dc.getAttributes(cnDTO.getDn());
  
             if (attrs == null) 
             {
                 propiedad = null;
             }
             else 
             {
                 propiedad = attrs.get(atributo);
             }
         }
         catch (Exception e) 
         {
             propiedad = null;
         }
         
         return propiedad;
    }

    private boolean loadConfigurationConeccion(UsersDTO usersDTO) 
    {        
    	boolean configLoad = false;
    	
    	//Validamos que se reciba usuario
        if(usersDTO==null)
        {
            System.out.println("El parametro recibido es null usersDTO (loadConfigurationConeccion)");
            return configLoad;
        }
                
	    cnDTO = new LdapConnectionDTO();          
        try   
        {        
            //Cargarmos el archivo de propiedades
            InputStream in = LdapBean.class.getClassLoader().getResourceAsStream("com/kallSonys/seg/biz/configuration/resources/ldapConfiguration.properties");
            if(in == null)
            {
                System.out.println("No se logró cargar el archivo de propiedades");
                return configLoad;
            }
        	
            //Creamos un Objeto de tipo Properties
            Properties propiedades = new Properties();                                 
            propiedades.load(in);
            
            //Obtenemos  parametros de coneccion desde el archivo de parametros
            String ipServidor = propiedades.getProperty("serverIP");
            String puertoServidor = propiedades.getProperty("serverPort");
            String complementoDN = propiedades.getProperty("userDN");
            String tipoAutenticacion = propiedades.getProperty("tipoAth");
            System.out.println("PRE");
            System.out.println("CONEXION AL LDAP: "+ipServidor+":"+puertoServidor+"-"+complementoDN+"-"+tipoAutenticacion);
            
            //Seteamos el objeto de conexion
            cnDTO.setServidor("ldap://"+ipServidor+":"+puertoServidor);//Servidor que aloja el LDAP
            cnDTO.setDn("cn="+usersDTO.getUser()+""+complementoDN);      //Ruta del Arbol LDAP
            cnDTO.setUsuario(cnDTO.getDn());                           //Usuario de Autenticacion            
            cnDTO.setClave(usersDTO.getPass());                          //Clave del usuario a logear
            cnDTO.setTipoAuth(tipoAutenticacion);                      //tipo de autentuicacion simple o por SSL
            configLoad = true;
        }
        catch (Exception e) 
        {
             System.out.println("Error carganodo el archivo de propiedades con la confifuracion del LDAP: "+e.getMessage());
             cnDTO=null;
        } 
        
        return configLoad;
	}



}
