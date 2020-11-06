package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import configuration.Config;
import model.Student;

@Controller
public class StudentController {

	@Autowired
	private Config config;

	@PostMapping("addStudentForm")
	public String showStudent(Student student) {
		System.out.println(student.toString());
		return "index";
	}

	@GetMapping("callControler")
	public ModelAndView showStudent() {
		ModelAndView modelAndView = new ModelAndView("formWithParams");
		modelAndView.addObject(new Student());
		return modelAndView;
	}

	@PostMapping("showparam")
	public RedirectView showparam(Student student, @RequestParam String msg) {
		System.out.println(msg);
		System.out.println(student);
		System.out.println(config.getCadena());
		return new RedirectView("callControler");
	}

	@GetMapping("addStudent")
	public ModelAndView addStudentPage() {
		ModelAndView mc = new ModelAndView();
		mc.setViewName("addStudentPage");
		Student student = new Student();
		student.setName("Alumno");
		mc.addObject(student);
		return mc;
	}

	public Config getConfig() {
		return config;
	}

	public void setConfig(Config config) {
		this.config = config;
	}


}
