package es.salesianos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import es.salesianos.model.Pet;
import es.salesianos.service.PetService;

@Controller
public class AddPetServlet{
	
	@Autowired
	private PetService service;
	
	@PostMapping("/addPet")
	protected String save(Pet pet){
		service.addPet(pet);
		return "listOwner";
	}
	
	@GetMapping("/addPet")
	protected String addPetPage(Pet pet) {
		return "addPet";
	}

}
