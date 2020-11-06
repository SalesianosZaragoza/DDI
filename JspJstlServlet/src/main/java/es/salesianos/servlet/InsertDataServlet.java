package es.salesianos.servlet;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Activity;
import es.salesianos.repository.ActividadesRepository;

public class InsertDataServlet extends BaseServlet{

	ActividadesRepository repository = new ActividadesRepository();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Activity activity = getActivityFromRequest(req);
		repository.insert(activity);
		redirect(req, resp, "/feedback.jsp");
	}

}
