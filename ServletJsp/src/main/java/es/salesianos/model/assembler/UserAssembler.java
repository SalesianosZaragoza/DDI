package es.salesianos.model.assembler;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import es.salesianos.model.User;

public class UserAssembler {

	public static User assembleUserFrom(HttpServletRequest req) {
		User user = new User();
		String nombre = req.getParameter("name");
		String dateOfBirth = req.getParameter("dob");
		user.setName(nombre);
		user.setDateOfBirth(dateOfBirth);
		return user;
	}
}