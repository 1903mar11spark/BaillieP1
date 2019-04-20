package com.revature.project1.util;


import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


		

public class ConnectionsUtil {
	public static Connection getConnection() throws SQLException {
		String url = "";
		String username = "";
		String password = "";
		try {
			   Class.forName("oracle.jdbc.driver.OracleDriver");
			}
			catch(ClassNotFoundException ex) {
			   System.out.println("Error: unable to load driver class!");
			}
		return DriverManager.getConnection(url, username, password);
	}

	public static Connection getConnectionFromFile() throws SQLException, IOException {
		Properties prop = new Properties();
		InputStream in = ConnectionsUtil.class.getClassLoader().getResourceAsStream("connection.properties");
		prop.load(in);
		try {
			   Class.forName("oracle.jdbc.driver.OracleDriver");
			}
			catch(ClassNotFoundException ex) {
			   System.out.println("Error: unable to load driver class!");
			}
		return DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"),
				prop.getProperty("password"));
	}

}
