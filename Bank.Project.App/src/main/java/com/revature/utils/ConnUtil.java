package com.revature.utils;

// Included classes:
import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
//import java.sql.SQLFeatureNotSupportedException;
//import java.util.Properties;
//import java.util.logging.Logger;

import org.postgresql.Driver;
import com.revature.exceptions.DBConnException;

public class ConnUtil {

	private ConnUtil() {
		super();
	}
	
	public static Connection getConnection() throws DBConnException {
		
		Connection conn = null;
		
		try {
			// register the driver
			DriverManager.registerDriver(new Driver());
			//System.out.println("DB Driver loaded successfully!");
			System.out.println();
			
			// set environment variables
			String url = System.getenv("db_url");
			//String username = System.getenv("db_username");
			//String password = System.getenv("db_password");
			String username = ("postgres");
			String password = ("sharon44");
			
			// Set conn to the connection string
			//System.out.println("url= " + url + "| Username= " + username + "| password= " + password );
			conn = DriverManager.getConnection(url, username, password);
			//System.out.println("Connenction successful!");
			System.out.println();
			
			
		} catch (SQLException e) {
			throw new DBConnException("!Error connecting to datasource!");
		}
		return conn;
	}
	
	

}
