/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kallSonys.common.dal.ldap.ejb;

import com.kallSonys.common.dal.ldap.scv.LdapRemoteBeanFacadeTest;
import javax.ejb.Stateless;

/**
 *
 * @author Frank
 */
@Stateless
public class LdapBeanImpTest implements LdapRemoteBeanFacadeTest {

    @Override
    public String connect() 
    {
        System.out.println("Conectado al BEAN de pruebas");        
        return "Conexion remota establecida";
    }

    @Override
    public String operacion(int a, int b) 
    {
          System.out.println("Operacion en el bean remoto");        
          return "El resultado de la opearcion es: "+(a+b);
    }

    

}
