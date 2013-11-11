/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kallSonys.seg.biz.ldap.ejb;

import com.kallSonys.seg.biz.ldap.facade.LdapFacade;
import com.kallSonys.seg.biz.ldap.transfer.LdapConnectionDTO;
import com.kallSonys.seg.biz.transfer.user.UsersDTO;

import java.io.InputStream;
import java.util.Hashtable;
import java.util.Properties;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
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
    public Attribute cargarPropiedadConexion(String atributo)
    {
            return null;
    }

    private void loadConfigurationConeccion(UsersDTO usersDTO) 
    {        
        if(usersDTO==null)
        {
            System.out.println("El parametro recibido es null usersDTO (loadConfigurationConeccion)");
            return;
        }
        
	    cnDTO = new LdapConnectionDTO();          
        try   
        {        
            //Cargarmos el archivo de propiedades
            InputStream in = LdapBean.class.getClassLoader().getResourceAsStream("com/kallSonys/seg/biz/configuration/resources/ldapConfiguration.properties");
            if(in == null)
            {
                System.out.println("No se logró cargar el archivo de propiedades");
                return;
            }
        	
            //Creamos un Objeto de tipo Properties
            Properties propiedades = new Properties();
           
            
            /**Cargamos el archivo desde la ruta especificada*/
            propiedades.load(in);
            //propiedades.load(new FileInputStream(URL_CONFIGURATION_FILE+""+NAME_CONFIGURATION_FILE));
            
            /**Obtenemos  parametros de coneccion desde el archivo de parametros*/
            String ipServidor = propiedades.getProperty("serverIP");
            String puertoServidor = propiedades.getProperty("serverPort");
            String complementoDN = propiedades.getProperty("userDN");
            String tipoAutenticacion = propiedades.getProperty("tipoAth");
            System.out.println("PRE");
            System.out.println(":::"+ipServidor+"-"+puertoServidor+"-"+complementoDN+"-"+tipoAutenticacion);
            //Seteamos el objeto de conexion
            cnDTO.setServidor("ldap://"+ipServidor+":"+puertoServidor);//Servidor que aloja el LDAP
            cnDTO.setDn("cn="+usersDTO.getUser()+""+complementoDN);      //Ruta del Arbol LDAP
            cnDTO.setUsuario(cnDTO.getDn());                           //Usuario de Autenticacion            
            cnDTO.setClave(usersDTO.getPass());                          //Clave del usuario a logear
            cnDTO.setTipoAuth(tipoAutenticacion);                      //tipo de autentuicacion simple o por SSL                                                                      
        }
        catch (Exception e) 
        {
             System.out.println("Error carganodo el archivo de propiedades con la confifuracion del LDAP: "+e.getMessage());
             cnDTO=null;
        }                
	}

    @Override
    public UsersDTO connect(UsersDTO usersDTO) {
        
        if(usersDTO==null)
        {
            System.out.println("El parametro recibido es null usersDTO. (connect)");
            return null;
        }
       
                this.userDTO = usersDTO;
	        loadConfigurationConeccion(userDTO);
	        if(cnDTO != null)
	        {
	            Hashtable<Object, Object> env = new Hashtable<Object, Object>();
	            env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
	            env.put(Context.PROVIDER_URL, cnDTO.getServidor());
	            env.put(Context.SECURITY_AUTHENTICATION, cnDTO.getTipoAuth());
	            env.put(Context.SECURITY_PRINCIPAL, cnDTO.getDn());
	            env.put(Context.SECURITY_CREDENTIALS, cnDTO.getClave());

	            try 
	            {
	                dc = new InitialDirContext(env);
	                userDTO.setAutenticado(true);
	                cargarPropiedadConexion("mail");
	            }
	            catch (NamingException ex) 
	            {
	                System.out.println("Error Autenticando mediante LDAP, Error causado por : " + ex.toString());
	                userDTO.setAutenticado(false);                
	            }
	        }
	        return userDTO;
    }


}
