package com.kallSonys.common.dal.persistence;

import java.sql.Connection;


public class ConnectionFactory {
	

	
	/**
	 * @return
	 */
	public static void getConnection() {
				
				
	    return;
	}
	
	public static Connection getConnection(String jndiRemoteName, boolean usingDs) 
        {		
		Connection conn = null;
		String jndiName	= "OMSBD";
		String url = "jdbc:oracle:thin:@190.145.18.211:1521/research";
		String driverClass = "oracle.jdbc.driver.OracleDriver";
		String user ="pc_test";
		String pwd ="pc_test";
				
		if (jndiRemoteName!=null  && usingDs == true)
                {						
		  conn = DatasourceConnectionFactory.getConnection(jndiRemoteName);			
		} 
                else 
                {					
	           conn = DriverManagerConnectionFactory.getConnection(driverClass, url, user, pwd);
		}
		
		return conn;
	}
}
