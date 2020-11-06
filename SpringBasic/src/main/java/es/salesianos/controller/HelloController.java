package es.salesianos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.salesianos.model.Activity;
import es.salesianos.repository.ActividadesRepository;
import spring.Printer;

@Controller
public class HelloController {
	
	@Autowired
	private	Printer printer;
	
	@Autowired
	private	ActividadesRepository repository;
	
	@RequestMapping(path="/hello", method=RequestMethod.POST)
	public void hello(@RequestParam String activityName, @RequestParam Integer aforo) {
		printer.imprimirHoja();
		//String name = req.getParameter("name");
		Activity activity = new Activity();
		activity.setName(activityName);
		activity.setAforo(aforo);
		repository.insert(activity);
	}

	public Printer getPrinter() {
		return printer;
	}

	public void setPrinter(Printer printer) {
		this.printer = printer;
	}

}
