package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.salesianos.connection.ConnectionH2;
import es.salesianos.connection.ConnectionManager;
import es.salesianos.model.Classroom;
import es.salesianos.model.User;
import es.salesianos.model.UserClassroomDto;

public class Repository {

	private static final String SQL_SEARCH = "SELECT USER.name, CLASSROOM.name FROM USER INNER JOIN CLASSROOM ON USER.course=CLASSROOM.id;";
	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test";
	ConnectionManager manager = new ConnectionH2();

	public User search(User userFormulario) {
		User userInDatabase = null;
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		Connection conn = manager.open(jdbcUrl);
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM USER WHERE name = ?");
			prepareStatement.setString(1, userFormulario.getName());
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				userInDatabase = new User();
				userInDatabase.setName(resultSet.getString(1));
				userInDatabase.setCourse(resultSet.getInt(2));
				userInDatabase.setDateOfBirth(resultSet.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);

		}
		manager.close(conn);
		return userInDatabase;
	}

	private void close(PreparedStatement prepareStatement) {
		if (null != prepareStatement) {
			try {
				prepareStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}

	private void close(ResultSet resultSet) {
		if (null != resultSet) {

			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}

	public void insert(User userFormulario) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("INSERT INTO USER (name,dateOfBirth)" + "VALUES (?, ?)");
			preparedStatement.setString(1, userFormulario.getName());
			preparedStatement.setDate(2, new java.sql.Date(userFormulario.getDateOfBirth().getTime()));
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
		}

		manager.close(conn);
	}

	public void update(User userFormulario) {
		Connection conn = manager.open(jdbcUrl);

		// codigo sql que inserta un usuario :P
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("UPDATE USER SET name = ?,dateOfBirth = ? WHERE name = ?");
			preparedStatement.setString(1, userFormulario.getName());
			preparedStatement.setDate(2, new java.sql.Date(userFormulario.getDateOfBirth().getTime()));
			preparedStatement.setString(3, userFormulario.getName());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
			manager.close(conn);
		}

	}

	public List<UserClassroomDto> searchAll() {
		List<UserClassroomDto> listUsers = new ArrayList<UserClassroomDto>();
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement(SQL_SEARCH);
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				UserClassroomDto dto = new UserClassroomDto();
				dto.setUserName(resultSet.getString(1));
				dto.setClassroomName(resultSet.getString(2));
				listUsers.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(resultSet);
			close(prepareStatement);
			manager.close(conn);
		}

		return listUsers;
	}

}
