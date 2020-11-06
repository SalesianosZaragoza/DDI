package es.salesianos.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Actor;
import es.salesianos.model.Pelicula;
import es.salesianos.service.Service;
import es.salesianos.service.Service;

public class PeliculaServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;

	private Service service = new Service();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String codString = req.getParameter("cod");
		String title = req.getParameter("title");
		String codDirectorString = req.getParameter("codDirector");
		Pelicula pelicula = new Pelicula();
		int cod = Integer.parseInt(codString);
		pelicula.setCod(cod);
		int codDirector = Integer.parseInt(codDirectorString);
		pelicula.setCodDirector(codDirector);
		pelicula.setTitle(title);
		service.insert(pelicula);
		doAction(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String codString = req.getParameter("cod");
		
		if(null != codString) {
			Pelicula pelicula = new Pelicula();
			int cod = Integer.parseInt(codString);
			pelicula.setCod(cod);
			service.delete(pelicula);
		}
		doAction(req, resp);
	}

	private void doAction(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		List<Pelicula> selectAllPelicula = service.selectAllPelicula();
		req.setAttribute("listAllPeliculas", selectAllPelicula);
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/pelicula.jsp");
		dispatcher.forward(req, resp);
	}
}
