package es.salesianos.servlet;

import java.io.IOException;
import java.util.Optional;


import es.salesianos.model.Activity;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public abstract class BaseServlet extends HttpServlet {

	public BaseServlet() {
		super();
	}

	protected Activity getActivityFromRequest(HttpServletRequest req) {
		Activity activity = new Activity();
		activity.setName(req.getParameter("name"));
		System.out.println(activity.getName());
		activity.setAforo(Integer.parseInt(req.getParameter("gauging")));
		System.out.println(activity.getAforo());
		return activity;
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp, String jsp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
		dispatcher.forward(req, resp);
	}

}