package es.salesianos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MyErrorController implements ErrorController{
	
	@RequestMapping("/error")
	  public String handleError() {
		return "error";
		
	}
	
	@Override
	public String getErrorPath() {
		return "/error";
	}

}
