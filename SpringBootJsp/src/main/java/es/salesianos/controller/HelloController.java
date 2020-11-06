package es.salesianos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import es.salesianos.model.Activity;
import es.salesianos.model.Owner;
import es.salesianos.service.OwnerService2;
import es.salesianos.service.OwnerServiceInterface;


@Controller
public class HelloController {
	
	@Autowired
	@Qualifier("ownerService")
	private OwnerServiceInterface service;
	
	
	//@PostMapping(path="/hello")
	@RequestMapping(path="/hello", method=RequestMethod.POST)
	public String hello(@RequestParam String activityName, @RequestParam Integer aforo) {
		System.out.println("activity name"+activityName);
		System.out.println("aforo"+aforo);
		return "welcome";
	}
	
	@RequestMapping(path="/hello2", method=RequestMethod.POST)
	public String saveActivity(@ModelAttribute("owner") Owner owner) {
		service.save(owner);
		return "welcome";
	}
	//@GetMapping(path="/activity1")
	@RequestMapping(path="/activity1", method=RequestMethod.GET)
	public ModelAndView loadActivityPage() {
		ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName("activity");
	    Activity activity = new Activity();
	    activity.setActivityName("hola chicos");
	    activity.setAforo(9999);
		modelAndView.addObject("activity", activity);
	    return modelAndView;
	}
	
	@RequestMapping(path="/activity3", method=RequestMethod.GET)
	public RedirectView loadEmptyActivityPage() {
	    return  new RedirectView("activity2");
	}
	
	@RequestMapping(path="/activity4", method=RequestMethod.GET)
	public String loadEmpty2ActivityPage() {
	    return  "activity2";
	}

	public OwnerServiceInterface getService() {
		return service;
	}

	public void setService(OwnerService2 service) {
		this.service = service;
	}


}
