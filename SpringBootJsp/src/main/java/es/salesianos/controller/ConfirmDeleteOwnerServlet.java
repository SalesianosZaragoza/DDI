package es.salesianos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConfirmDeleteOwnerServlet {
	
	@GetMapping("/confirmDeleteOwner")
	protected ModelAndView confirmDelete(@RequestParam Integer codOwner) {
		ModelAndView model = new ModelAndView("confirmDelete");
		model.addObject("codOwner", codOwner);
		return model;
	}

	
	
}
