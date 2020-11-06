package es.salesianos.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import es.salesianos.model.Owner;
import es.salesianos.service.OwnerServiceInterface;

@Controller
public class AddOwnerServlet {
	
	@Autowired
	private OwnerServiceInterface service;
	
	@PostMapping(path="/addOwner")
	public String saveOwner(@ModelAttribute(name = "owner") Owner student) {
		// service.addOwner(student);
		System.out.println(student.toString());
		return "ownerSaved";
	}
	@GetMapping(path="addOwner")
	public ModelAndView getAddOwnerPage() {
		ModelAndView model = new ModelAndView("addOwner");
		model.addObject(new Owner());
		return model;
	}

	@GetMapping(path = "listOwner")
	public String getListOwnerPage() {
		return "listOwner";
	}


	
	

}
