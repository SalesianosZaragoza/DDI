package com.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dao.PersonDao;
import com.dao.PersonPlusDao;
import com.entities.Person;
import com.util.ConnectionConfiguration;

public class PersonDaoH2Impl implements PersonDao, PersonPlusDao {

	public void createPersonTable() {
		Connection connection = null;
		Statement statement = null;

		try {
			connection = ConnectionConfiguration.getConnection();
			statement = connection.createStatement();
			statement.execute("CREATE TABLE IF NOT EXISTS person (id bigint auto_increment," +
					"first_name varchar(55), last_name varchar(55))");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeStatement(statement);
			closeConnection(connection);
		}
	}

	private void closeConnection(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private void closeStatement(Statement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void insert(Person person) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = ConnectionConfiguration.getConnection();
			preparedStatement = connection.prepareStatement("INSERT INTO person (first_name,last_name)" +
					"VALUES (?, ?)");
			preparedStatement.setString(1, person.getFirstName());
			preparedStatement.setString(2, person.getLastName());
			preparedStatement.executeUpdate();
			System.out.println("INSERT INTO person (first_name,last_name)" +
					"VALUES (?, ?)");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closePreparedStatement(preparedStatement);

			closeConnection(connection);
		}
	}

	private void closePreparedStatement(PreparedStatement preparedStatement) {
		if (preparedStatement != null) {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public Person selectById(int id) {
		Person person = new Person();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = ConnectionConfiguration.getConnection();
			preparedStatement = connection.prepareStatement("SELECT * FROM person WHERE id = ?");
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				person.setId(resultSet.getInt("id"));
				person.setFirstName(resultSet.getString("first_name"));
				person.setLastName(resultSet.getString("last_name"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResultset(resultSet);
			closePreparedStatement(preparedStatement);
			closeConnection(connection);
		}

		return person;
	}

	public Person selectByLastName(String lastname) {
		return null;
	}

	private void closeResultset(ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public List<Person> selectAll() {
		List<Person> persons = new ArrayList<Person>();
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			connection = ConnectionConfiguration.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM person");

			while (resultSet.next()) {
				Person person = new Person();
				person.setId(resultSet.getInt("id"));
				person.setFirstName(resultSet.getString("first_name"));
				person.setLastName(resultSet.getString("last_name"));

				persons.add(person);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResultset(resultSet);
			closeStatement(statement);
			closeConnection(connection);
		}

		return persons;
	}

	public void delete(int id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = ConnectionConfiguration.getConnection();
			preparedStatement = connection.prepareStatement("DELETE FROM person WHERE id = ?");
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();

			System.out.println("DELETE FROM person WHERE id = ?");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closePreparedStatement(preparedStatement);
			closeConnection(connection);
		}
	}

	public void update(Person person, int id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = ConnectionConfiguration.getConnection();
			preparedStatement = connection.prepareStatement("UPDATE person SET " +
					"first_name = ?, last_name = ? WHERE id = ?");

			preparedStatement.setString(1, person.getFirstName());
			preparedStatement.setString(2, person.getLastName());
			preparedStatement.setInt(3, id);
			preparedStatement.executeUpdate();

			System.out.println("UPDATE person SET " +
					"first_name = ?, last_name = ? WHERE id = ?");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closePreparedStatement(preparedStatement);
			closeConnection(connection);
		}
	}
}
