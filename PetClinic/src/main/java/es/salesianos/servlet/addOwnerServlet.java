package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Owner;
import es.salesianos.service.OwnerService;

/**
 * Servlet implementation class addOwnerServlet
 */
@WebServlet("/addOwnerServlet")
public class addOwnerServlet extends HttpServlet {
private OwnerService service = new OwnerService();
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Owner owner = service.assembleOwnerFromRequest(req);
		service.addOwner(owner);
		redirect(req,resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ownerSaved.jsp");
		dispatcher.forward(req,resp);
	}

	
	

}
