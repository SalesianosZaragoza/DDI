package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionConfiguration {

	public static Connection getConnection() throws Exception {
		Connection connection = null;

		try {
			Class.forName("org.h2.Driver");
			connection = DriverManager.getConnection("jdbc:h2:file:./src/main/resources/test","sa","");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
//			System.out.println(e.getMessage());
		}
		return connection;
	}
	

}
