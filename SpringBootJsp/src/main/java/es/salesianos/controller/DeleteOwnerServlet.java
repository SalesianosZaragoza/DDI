package es.salesianos.controller;

import java.io.IOException;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.salesianos.service.OwnerServiceInterface;

@Controller
public class DeleteOwnerServlet {

	@Autowired
	OwnerServiceInterface service;
	
	@GetMapping("deleteOwner")
	protected String deleteOwner(@RequestParam String answer, @RequestParam Integer codOwner)
			throws ServletException, IOException {
		if(answer.equals("SI")) {
			service.deleteOwner(codOwner);
		}
		return "listOwner";
	}
	
}
