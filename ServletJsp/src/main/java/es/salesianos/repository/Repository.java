package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import es.salesianos.connection.ConnectionH2;
import es.salesianos.connection.ConnectionManager;
import es.salesianos.model.User;

public class Repository {
	
	private static final String jdbcUrl = null;
	ConnectionManager manager = new ConnectionH2();

	public User search(User userFormulario) {
		User userInDatabase= null;
		Connection conn = manager.open(jdbcUrl);
		try {
			PreparedStatement prepareStatement = conn.prepareStatement("SELECT * FROM USER WHERE name = ?");
			prepareStatement.setString(1, userFormulario.getName());
			ResultSet resultSet = prepareStatement.executeQuery();
			while(resultSet.next()){
				userInDatabase = new User();
				userInDatabase.setName(resultSet.getString(0));
				userInDatabase.setDateOfBirth(resultSet.getString(1));
				userInDatabase.setCourse(resultSet.getString(2));
			}
			resultSet.close();
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		
		manager.close(conn);
		return userInDatabase;
	}

	public void insert(User userFormulario) {
		Connection conn = manager.open(jdbcUrl);
		// codigo sql que  inserta un usuario
		manager.close(conn);
		
	}

	public void update(User userFormulario) {
		Connection conn = manager.open(jdbcUrl);
		// codigo sql que  inserta un usuario
		manager.close(conn);
	}


}
