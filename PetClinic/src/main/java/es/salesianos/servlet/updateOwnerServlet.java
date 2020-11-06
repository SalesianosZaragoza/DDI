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

public class updateOwnerServlet extends HttpServlet{
OwnerService service = new OwnerService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Owner owner = OwnerAssembler.assembleOwnerFrom(req);
		service.insertOrUpdate(owner);
		redirect(req, resp);
	}
	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listOwner.jsp");
		dispatcher.forward(req,resp);
	}
}
