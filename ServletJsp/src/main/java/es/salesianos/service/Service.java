package es.salesianos.service;

import java.sql.Connection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.connection.ConnectionH2;
import es.salesianos.connection.ConnectionManager;
import es.salesianos.model.User;
import es.salesianos.model.assembler.UserAssembler;
import es.salesianos.utils.DateConverter;

public class Service {
	
	
	private DateConverter converter = new DateConverter();
	private ConnectionManager manager = new ConnectionH2();
	
	
	public User assembleUserFromRequest(HttpServletRequest req) {
		return UserAssembler.assembleUserFrom(req);
	}

	public void insertOrUpdate(User user) {
		Connection conn = manager.open("jdbc:h2:file:./src/main/resources/test");
		manager.close(conn);
	}

	public void calculateAgeAndAddIntoRequest(HttpServletRequest req, Date date) {
		Integer yearNac = converter.getAge(date);
		req.setAttribute("age", yearNac.toString());
	}
	
	
	public DateConverter getConverter() {
		return converter;
	}
	public void setConverter(DateConverter converter) {
		this.converter = converter;
	}
	public ConnectionManager getManager() {
		return manager;
	}
	public void setManager(ConnectionManager manager) {
		this.manager = manager;
	}
	
	
	

}
