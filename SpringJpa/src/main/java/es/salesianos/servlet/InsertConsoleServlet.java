package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import es.salesianos.model.Console;

@WebServlet("/insertconsole")
public class InsertConsoleServlet extends HttpServlet {

	private WebApplicationContext applicationContext;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		JpaRepository<Console, Integer> repository = (JpaRepository<Console, Integer>) applicationContext
				.getBean("consolerepository");
		String name = req.getParameter("name");
		Console console = new Console();
		console.setName(name);
		repository.save(console);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/");
		dispatcher.forward(req, resp);
	}

	@Override
	public void init() throws ServletException {
		applicationContext = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		super.init();
	}

}
