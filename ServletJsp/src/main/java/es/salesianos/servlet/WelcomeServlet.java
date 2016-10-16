package es.salesianos.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.connection.ConnectionH2;
import es.salesianos.connection.ConnectionManager;
import es.salesianos.model.User;
import es.salesianos.model.assembler.UserAssembler;
import es.salesianos.utils.DateConverter;

public class WelcomeServlet extends HttpServlet{
	
	private DateConverter converter = new DateConverter();
	private ConnectionManager manager = new ConnectionH2();
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = assembleUserFromRequest(req);
		insertOrUpdate(user);
		calculateAgeAndAddIntoRequest(req, user.getDateOfBirth());
		redirect(req,resp);
	}

	private void insertOrUpdate(User user) {
		Connection conn = manager.open("jdbc:h2:file:./src/main/resources/test");
		manager.close(conn);
	}

	private void calculateAgeAndAddIntoRequest(HttpServletRequest req, Date date) {
		Integer yearNac = converter.getAge(date);
		req.setAttribute("age", yearNac.toString());
	}

	private User assembleUserFromRequest(HttpServletRequest req) {
		return UserAssembler.assembleUserFrom(req);
	}

	private void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/fin.jsp");
		dispatcher.forward(req,resp);
	}
	
}
