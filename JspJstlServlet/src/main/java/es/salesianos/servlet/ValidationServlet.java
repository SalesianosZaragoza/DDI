package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.connection.AbstractConnection;
import es.salesianos.connection.H2Connection;
import es.salesianos.model.Activity;
import es.salesianos.repository.ActividadesRepository;

/**
 * Servlet implementation class ValidationServlet
 */
public class ValidationServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
	ActividadesRepository repository = new ActividadesRepository();
	
    public ValidationServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		Activity activity = getActivityFromRequest(request);
		boolean activityIsRealizable = repository.activityIsRealizable(activity);
//		request.getSession().setAttribute("isRealizable", activityIsRealizable);
		request.setAttribute("isRealizable", activityIsRealizable);
//		if(repository.activityIsRealizable(activity)) {
//			redirect(request, response, "/ok.jsp");
//		}else
//			redirect(request, response, "/fail.jsp");
//	}
		redirect(request, response, "/msgValidation.jsp");
	}
}










