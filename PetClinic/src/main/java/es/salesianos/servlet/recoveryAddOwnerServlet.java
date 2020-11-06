package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Owner;
import es.salesianos.service.OwnerService;

public class recoveryAddOwnerServlet extends HttpServlet{
	OwnerService service = new OwnerService();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String codOwner = req.getParameter("codOwner");
		Owner ownerFormulario= new Owner();
		ownerFormulario.setCodOwner(Integer.parseInt(codOwner));
		////Owner ownerFromDatabase = service.search(ownerFormulario.getCodOwner());
		req.setAttribute("owner", ownerFormulario);
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addPet.jsp");
		dispatcher.forward(req,resp);
	}
}
