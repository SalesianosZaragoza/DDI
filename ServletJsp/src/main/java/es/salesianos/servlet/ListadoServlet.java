package es.salesianos.servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import es.salesianos.model.User;
import es.salesianos.model.UserClassroomDto;
import es.salesianos.service.Service;

public class ListadoServlet extends HttpServlet {
	
	private Service servicio = new  Service();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<UserClassroomDto> listAllUsers = servicio.listAllUsers();
		req.setAttribute("listAllUsers", listAllUsers);
		redirect(req,resp);
	}
	
	
	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listado.jsp");
		dispatcher.forward(req,resp);
	}
}
