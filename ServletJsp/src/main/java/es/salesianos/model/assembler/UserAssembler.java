package es.salesianos.model.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.User;

public class UserAssembler {

	public static User assembleUserFrom(HttpServletRequest req) {
		User user = new User();
		String nombre = req.getParameter("name");
		String course = req.getParameter("course");
		String dateOfBirth = req.getParameter("dob");
		user.setName(nombre);
		user.setCourse(course);
		user.setDateOfBirth(dateOfBirth);
		return user;
	}
}