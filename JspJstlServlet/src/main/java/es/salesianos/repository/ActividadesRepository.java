package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.salesianos.connection.AbstractConnection;
import es.salesianos.connection.H2Connection;
import es.salesianos.model.Activity;

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
					.prepareStatement("SELECT * FROM ACTIVITY " + "WHERE name = ?");
			preparedStatement.setString(1, activity.getName());
							System.out.println(activity.getName());

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int maxGaugeAllowed = resultSet.getInt("gauging");
				System.out.println(maxGaugeAllowed);
				if(activity.getAforo() < maxGaugeAllowed) {
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


	public List<Activity> listAll() {
		List<Activity> lista = new ArrayList<>();
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("SELECT * FROM ACTIVITY ");

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Activity activity = new Activity();
				activity.setAforo(resultSet.getInt("gauging"));
				activity.setName(resultSet.getString("name"));
				
				lista.add(activity);
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
		return lista;
	}


	public void deleteWhereName(String item) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("DELETE FROM Activity WHERE name = ?");
			preparedStatement.setString(1, item);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
	}

	
}
