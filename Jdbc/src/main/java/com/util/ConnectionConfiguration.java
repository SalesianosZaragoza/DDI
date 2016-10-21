package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionConfiguration {

	public static Connection getConnection() {
		Connection connection = null;

		try {
			Class.forName("org.h2.Driver");
			connection = DriverManager.getConnection("jdbc:h2:file:./src/main/resources/test","sa","");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return connection;
	}

}
