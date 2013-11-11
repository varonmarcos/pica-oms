package com.kallSonys.common.dal.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DriverManagerConnectionFactory {
	
			
	public static Connection getConnection(String driverClass, String url, String user, String password) {
		
		Connection conn = null;
		
		try
                {			
                    Class.forName(driverClass);
                    conn = DriverManager.getConnection(url, user, password);
                    return conn;

		} catch (SQLException se) 
                {		                        
                    System.out.println("Error a intentar crear conexion por driverManager. "+ se);
                    return null;
		} catch (ClassNotFoundException cnfe) 
                {			
			System.out.println("Erro al intentar crear conexion por DriverManager. "+cnfe);	
                        return null;
		}		
	}
}
