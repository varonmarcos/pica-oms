package com.kallSonys.common.dal.persistence;

import java.sql.*;
import javax.sql.*;
import javax.naming.Context;
import javax.naming.NamingException;
import java.util.Hashtable;
import javax.naming.InitialContext;


public class DatasourceConnectionFactory {

	private static Hashtable<String, DataSource> cacheDatasource = new Hashtable<String, DataSource>();
		
	
	public static Connection getConnection(String jndiRemoteName) {
		return getConnectionForDatasource(jndiRemoteName);
	}
        
	private static Connection getConnectionForDatasource(String jndiRemoteName) {
		
		Connection connection = null;

		try 
                {						
                    DataSource ds = (DataSource) cacheDatasource.get(jndiRemoteName);
                    // Si no está en cache el datasource, obtenerlo de un contexto
                    if (ds == null) {
                            Context context = new InitialContext();
                            ds = (DataSource) context.lookup(jndiRemoteName);	
                            cacheDatasource.put(jndiRemoteName, ds);
                    }
                    connection = ds.getConnection();
                    return connection;
			
		} catch (NamingException ex) {
			
			System.out.println("Error al intentar obtener datasource: " + jndiRemoteName + " - "+ ex);
                        return null;
			
		} catch (SQLException se) {
			
			System.out.println("Error al intentar obtener conexi�n de datasource: "  + jndiRemoteName + " - "+ se);
                        return null;
		}
	}
}
