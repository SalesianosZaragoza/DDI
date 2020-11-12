package es.salesianos.service;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.connection.ConnectionH2;
import es.salesianos.connection.ConnectionManager;
import es.salesianos.model.User;
import es.salesianos.model.UserClassroomDto;
import es.salesianos.model.assembler.UserAssembler;
import es.salesianos.repository.Repository;
import es.salesianos.utils.DateConverter;

public class Service {
	
	
	private Repository repository = new Repository();
	private DateConverter converter = new DateConverter();
	
	
	public User assembleUserFromRequest(HttpServletRequest req) {
		return UserAssembler.assembleUserFrom(req);
	}

	public void insertOrUpdate(User userFormulario) {
		User userInDatabase = repository.search(userFormulario);
		if(null == userInDatabase){
			repository.insert(userFormulario);
		}else{
			repository.update(userFormulario);
		}
	}

	public void calculateAgeAndAddIntoRequest(HttpServletRequest req, Date date) {
		Integer yearNac = converter.getAge(date);
		req.setAttribute("age", yearNac.toString());
	}
	
	
	public List<UserClassroomDto> listAllUsers() {
		return repository.searchAll();
	}
	
	
	public DateConverter getConverter() {
		return converter;
	}
	public void setConverter(DateConverter converter) {
		this.converter = converter;
	}

	public Repository getRepository() {
		return repository;
	}

	public void setRepository(Repository repository) {
		this.repository = repository;
	}
	
	
	

}
