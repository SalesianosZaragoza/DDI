package es.salesianos.servlet;

import java.io.IOException;

import es.salesianos.repository.ActividadesRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/eliminar")
public class EliminarServlet extends HttpServlet{
	ActividadesRepository repo = new ActividadesRepository();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String item = req.getParameter("item");
		repo.deleteWhereName(item);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listActivities.jsp");
		dispatcher.forward(req, resp);
		
	}

}
