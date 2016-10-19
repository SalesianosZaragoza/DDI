package es.salesianos.servlet;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import es.salesianos.service.Service;


@RunWith(MockitoJUnitRunner.class)
public class WelcomeServletTest {

	@Spy
	MockHttpRequest req;		

	@Mock
	HttpServletResponse resp;

	Service service = new Service();
	
	MockedWelcomeServlet servlet = new MockedWelcomeServlet();
	
	
	@Before
	public void setup() {
		servlet.setService(service);
		Mockito.when(req.getParameter("dob")).thenReturn("2000-12-10");
	}
	
	@Test
	public void testDoPost() throws ServletException, IOException {
		servlet.doPost(req, resp);
		assertEquals("15", req.getAttribute("age"));
	}
	
	class MockedWelcomeServlet extends WelcomeServlet{
		
		protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		}
		
	}
	
	abstract class MockHttpRequest implements HttpServletRequest{
		private final Map<String, Object> attribute = new HashMap<String, Object>();


	    public Object getAttribute(String name)
	    {
	    	return attribute.get(name);
	    }
	    
	    public void setAttribute(String key, Object value)
	    {
	        attribute.put(key,value);
	    }
	
	}

}
