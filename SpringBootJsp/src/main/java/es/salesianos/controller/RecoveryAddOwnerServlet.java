package es.salesianos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import es.salesianos.model.Owner;
import es.salesianos.service.OwnerServiceInterface;

@Controller
public class RecoveryAddOwnerServlet {

	@Autowired
	OwnerServiceInterface service;

	@GetMapping("recoveryAddCodOwner")
	public ModelAndView doGet(@RequestParam Integer codOwner) {
		ModelAndView model = new ModelAndView("addPet");
		Owner owner = new Owner();
		owner.setCodOwner(codOwner);
		model.addObject("owner", owner);
		return model;
	}

}
