package es.salesianos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import es.salesianos.model.Owner;
import es.salesianos.service.OwnerServiceInterface;

@Controller
public class ListOwnerServlet {

	@Autowired
	@Qualifier("ownerService")
	OwnerServiceInterface service;

	@PostMapping(path = "/listAllOwners")
	public ModelAndView addOwner() {
		List<Owner> owners = service.listAll();
		System.out.println(owners);
		ModelAndView model = new ModelAndView("listOwner");
		model.addObject("listAllOwners", owners);
		return model;
	}

}
