package es.salesianos.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import es.salesianos.model.Console;

@WebServlet("/listconsole")
public class ListConsoleServlet extends HttpServlet {

	private WebApplicationContext applicationContext;
	
	@Autowired
	JpaRepository<Console, Integer> repository;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Console example = new Console();
		example.setName("nintendo");
		List<Console> consoles = repository.findAll(example );
		req.setAttribute("consoles", consoles);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/");
		dispatcher.forward(req, resp);
	}

	@Override
	public void init() throws ServletException {
		applicationContext = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		super.init();
	}

}
