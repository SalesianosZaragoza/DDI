package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Owner;
import es.salesianos.model.assembler.OwnerAssembler;
import es.salesianos.service.OwnerService;

public class deleteOwnerServlet extends HttpServlet{

	OwnerService service = new OwnerService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String answer = req.getParameter("answer");
		if(answer.equals("SI")) {
			String codOwner = req.getParameter("codOwner");
			service.deleteOwner(Integer.parseInt(codOwner));
		}
		redirect(req, resp);
	}
	
	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listOwner.jsp");
		dispatcher.forward(req,resp);
	}
}
