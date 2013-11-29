/**
 * 
 */
package com.kallSonys.common.dal.conectionjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Juan Pablo Aranda Galvis
 *
 */
public class JBDConnection {

	private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_CONNECTION = "jdbc:oracle:thin:@192.168.0.109:1521:orcl";
	private static final String DB_USER = "OMS";
	private static final String DB_PASSWORD = "OMS";
	
	@SuppressWarnings("unused")
	public static final Connection getDBConnection() {	 
		Connection dbConnection = null;
 
		try {
 			Class.forName(DB_DRIVER);
 		} catch (ClassNotFoundException e) {
 			System.out.println(e.getMessage());
 		}
 		try {
 			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER,DB_PASSWORD);
			return dbConnection;
 
		} catch (SQLException e) {
 
			System.out.println(e.getMessage());
 
		}
 		return dbConnection;
 
	}
	
	public static final void closeDBConnection(Connection con){
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
