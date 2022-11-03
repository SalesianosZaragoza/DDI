package es.salesianos.servlet;

import java.io.IOException;
import java.util.List;

import es.salesianos.model.Activity;
import es.salesianos.repository.ActividadesRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/verActividades")
public class VerActividadesServlet extends HttpServlet {
	ActividadesRepository repo = new ActividadesRepository();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Activity> actividades = repo.listAll();
		req.setAttribute("lista", actividades);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listActivities.jsp");
		dispatcher.forward(req, resp);
	}
}
