package es.salesianos.servlet;

import java.io.IOException;
import java.util.Optional;



import es.salesianos.model.Activity;
import es.salesianos.repository.ActividadesRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/insert")
public class InsertDataServlet extends BaseServlet{

	ActividadesRepository repository = new ActividadesRepository();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Activity activity = getActivityFromRequest(req);
		repository.insert(activity);
		redirect(req, resp, "/feedback.jsp");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

}
