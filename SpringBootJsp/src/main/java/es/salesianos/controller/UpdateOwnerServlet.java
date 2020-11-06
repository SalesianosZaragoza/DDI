package es.salesianos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import es.salesianos.model.Owner;
import es.salesianos.service.OwnerServiceInterface;

@Controller
public class UpdateOwnerServlet {

	@Autowired
	@Qualifier("ownerService")
	OwnerServiceInterface service;

	@PostMapping(path="/updateOwner")
	public String addOwner(@ModelAttribute Owner owner) {
		service.insertOrUpdate(owner);
		return "listOwner";
	}

}
