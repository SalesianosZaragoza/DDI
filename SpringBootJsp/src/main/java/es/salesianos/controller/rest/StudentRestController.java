
package es.salesianos.controller.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.salesianos.model.Alumno;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(value = "/api/ALUMNOS")
public class StudentRestController {

	List<Alumno> alumnos = new ArrayList<Alumno>();
	int id = 1;
	final static String lo_que_sea = "lo_que_sea";
	@PostMapping
	@RequestMapping(value = "/INSERT", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Alumno> create(@RequestBody Alumno alumno) {
		alumno.setId(this.id);
		alumnos.add(alumno);
		id++;

		return new ResponseEntity<>(alumno, HttpStatus.CREATED);
	}

	@GetMapping
	@RequestMapping(value = "/DELETEALL")
	public ResponseEntity<List<Alumno>> deleteAll() {
		alumnos.clear();	
		id = 1;
		return new ResponseEntity<>(alumnos, HttpStatus.OK);
	}
	@PostMapping
	@RequestMapping(value = "/LIST")
	public ResponseEntity<List<Alumno>> ListAll() {

		return new ResponseEntity<>(alumnos, HttpStatus.OK);
	}

	@GetMapping
	@RequestMapping(value = "DELETE/")
	public ResponseEntity<List<Alumno>> Delete(@RequestParam Integer id) {
		if (id==0) {
			return new ResponseEntity<List<Alumno>>(HttpStatus.NOT_FOUND);
		}
		Alumno al = null;
		for (int i = 0; i <= alumnos.size(); i++) {
				al = alumnos.get(i).getId() == id ? alumnos.get(i) : null;
				if(al != null ) break;
		}
		if(al != null) {
			alumnos.remove(al);
		}

		// Se elimina al alumno y se devuelve la lista actual de alumnos
		return new ResponseEntity<>(alumnos, HttpStatus.OK);
	}

	@GetMapping
	@RequestMapping(value = "UPDATE/{id}/")
	public ResponseEntity<Alumno> UpdateAlumno(@PathVariable("id") int id,
			@RequestParam(value = "fct") String fct) {

		for (Alumno al : alumnos) {
			if (al.getId() == id) {
				al.setFct(fct);
				return new ResponseEntity<>(al, HttpStatus.ACCEPTED);
			}
		}
		return new ResponseEntity<>(HttpStatus.CONFLICT);

	}
}