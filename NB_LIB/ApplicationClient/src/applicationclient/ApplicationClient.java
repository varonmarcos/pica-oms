/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationclient;

import com.kallSonys.common.dal.jpa.facade.AddressFacade;
import java.util.Properties; 
import javax.naming.Context;
import javax.naming.InitialContext;
import com.kallSonys.common.dal.ldap.scv.LdapRemoteBeanFacadeTest;
import com.kallSonys.common.dal.persistence.ConnectionFactory;
import java.sql.Connection;
import javax.ejb.EJB;
/**
 *
 * @author Frank
 */
public class ApplicationClient {

    @EJB
    private static AddressFacade dfl;
    static Context contexto;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
       System.out.println("MAIN: Prueba"); 
       System.out.println("::: "+getContext("192.168.1.3","7001"));
       //System.out.println("Cantidad de registros en ADDRESS: "+dfl.count());
       System.out.println("FIN MAIN");
    }
    
    private static void pruebaConeccionBD()
    {
      Connection cnn = ConnectionFactory.getConnection(null, false);
      if(cnn != null)      
      {
          System.out.println("CNN OK");
      }else
      {
          System.out.println("CNN PAILA");
      }
    }
    
    private void ldap()
    {
        //String jdniBeanName="com.kallSonys.common.dal.ldap.scv.LdapRemoteBeanFacadeTest";
        String jdniBeanName="com.kallSonys.common.dal.ldap.ejb.LdapBeanImpTest";
        try 
        {                   	                                    
            /**Obtenemos  parametros de coneccion desde el archivo de parametros*/           
            String ipWLServerContext ="192.168.1.4";
            String portWLServerContext = "7001";
            
             System.out.println("jdniBeanName: "+jdniBeanName);
            contexto = ApplicationClient.getContext(ipWLServerContext, portWLServerContext);
        
            System.out.println("contexto: "+contexto);
            System.out.println("jdniBeanName: "+jdniBeanName);
            
    	     LdapRemoteBeanFacadeTest objRemote = (LdapRemoteBeanFacadeTest)contexto.lookup("jdniBeanName");    			
             if(objRemote!=null)
             {
                 System.out.println("BEAN remoto recuperado");
                 System.out.println(":1:1:"+objRemote.connect());
                 System.out.println(":2:2:"+objRemote.operacion(5, 44));
             }else
             {
                 System.out.println("El BEAN es remoto");
             }
            return;
        } catch (Exception e) {
            System.out.println("ERROR: "+e.getMessage());
        }
    }
    
    private static Context getContext(String ipWLServerContext, String portWLServerContext)
    {
	  try 
            {
               Properties h = new Properties();

		h.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
		h.put(Context.PROVIDER_URL, "t3://localhost:7001");
		h.put(Context.SECURITY_PRINCIPAL, "weblogic");
		h.put(Context.SECURITY_CREDENTIALS, "lucasian.*");
                System.out.println("getContext: t3://"+ipWLServerContext +":"+portWLServerContext);
                System.out.println("1");
                
               
                
		return new InitialContext(h);
            
                }
		  catch (Exception e) 
		  {
			  System.out.println("{common.jee.util.bean}: Error cargando el contexto de la aplicacion. "+e.getMessage());			  
		  }	
          return null;
        }
    
    
}
