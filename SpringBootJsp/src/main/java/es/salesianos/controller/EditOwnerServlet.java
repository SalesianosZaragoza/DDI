package es.salesianos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import es.salesianos.model.Owner;
import es.salesianos.service.OwnerServiceInterface;

@Controller
public class EditOwnerServlet {

	@Autowired
	@Qualifier("ownerService")
	OwnerServiceInterface service;

	@GetMapping("editOwner")
	protected ModelAndView editOwner(@RequestParam Integer codOwner) {
		ModelAndView model = new ModelAndView("ownerEdited");
		Owner ownerFromDatabase = service.findById(codOwner).get();
		model.addObject("owner", ownerFromDatabase);
		return model;
	}

}
