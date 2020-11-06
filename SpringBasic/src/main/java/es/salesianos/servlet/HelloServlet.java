package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import es.salesianos.model.Activity;
import es.salesianos.repository.ActividadesRepository;
import spring.Printer;

public class HelloServlet extends HttpServlet {
	
	@Autowired
	private Printer printer;
	
	@Autowired
	private	ActividadesRepository repository;
	
	public void init(ServletConfig config) throws ServletException {
	    super.init(config);
	    SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
	      config.getServletContext());
	  }
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		printer.imprimirHoja();
		String name = req.getParameter("name");
		Activity activity = new Activity();
		activity.setName(name);
		activity.setAforo(1);
		repository.insert(activity);
	}

	public Printer getPrinter() {
		return printer;
	}

	public void setPrinter(Printer printer) {
		this.printer = printer;
	}

	public ActividadesRepository getRepository() {
		return repository;
	}

	public void setRepository(ActividadesRepository repository) {
		this.repository = repository;
	}

}
