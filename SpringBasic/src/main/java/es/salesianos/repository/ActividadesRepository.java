package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import es.salesianos.connection.AbstractConnection;
import es.salesianos.connection.H2Connection;
import es.salesianos.model.Activity;

@Repository
public class ActividadesRepository {

	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test;INIT=RUNSCRIPT FROM 'classpath:scripts/create.sql'";
	AbstractConnection manager = new H2Connection();


	public void insert(Activity activity) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("INSERT INTO Activity (name,gauging)" + "VALUES (?, ?)");
			preparedStatement.setString(1, activity.getName());
			preparedStatement.setInt(2, activity.getAforo());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}

	}


	public boolean activityIsRealizable(Activity activity) {
		Boolean isRealizable = false;
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("SELECT * FROM ACTIVITY WHERE name = ?");
			System.out.println(activity.getName());
			preparedStatement.setString(1, activity.getName());
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int gauging = resultSet.getInt("gauging");
				if(activity.getAforo() < gauging) {
					isRealizable = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
		return isRealizable;
	}

	
}
