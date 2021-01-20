package es.salesianos.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import es.salesianos.model.Activity;


@Controller
public class ActivityController {

	List<Activity> list = new ArrayList<Activity>();
	
	@GetMapping(path = "/addActivity")
	public ModelAndView addActivity() {
		ModelAndView formAddActivity = new ModelAndView();
		formAddActivity.setViewName("formAddActivity");
		formAddActivity.addObject("activity", new Activity());
		return formAddActivity;
	}
	
	@PostMapping(path = "insertActivity")
	public String insertarActividad(Activity activity) {
		System.out.println("guardando actividad");
		System.out.println(activity);
		list.add(activity);
	return "thankyouforplaying";	
	}

}
