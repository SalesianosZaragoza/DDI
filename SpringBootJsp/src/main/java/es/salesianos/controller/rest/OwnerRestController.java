package es.salesianos.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import es.salesianos.model.Owner;
import es.salesianos.service.OwnerServiceInterface;

@RestController
@RequestMapping("/api/")
public class OwnerRestController {

	@Autowired
	@Qualifier("ownerService")
	private OwnerServiceInterface service;

// http:localhost:8080/api/listAllOwners
	@PostMapping("/listAllOwners")
	@ResponseBody
	public String listAllOwnersPost() {
		List<Owner> owners = service.listAll();
		return "<div>Thanks For using Post!!!</div>";
	}

	// http:localhost:8080/api/listAllOwners
	@GetMapping("/listAllOwners")
	@ResponseBody
	public String listAllOwnersGet() {
		List<Owner> owners = service.listAll();
		return "Thanks For using Get!!!";
	}

	@PostMapping("/save")
	public ResponseEntity postController(@RequestBody Owner owner) {
		try {
			service.insertOrUpdate(owner);
			return ResponseEntity.ok(HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@PostMapping("/listAllOwnersAsJsonPost")
	@ResponseBody
	public List<Owner> listAllOwnersAsJsonPost() {
		List<Owner> owners = service.listAll();
		return owners;
	}

	@RequestMapping(value = "/listAllOwnersAsJsonGet", method = RequestMethod.GET, produces = "application/json")
	public List<Owner> listAllOwnersAsJsonGet() {
		List<Owner> owners = service.listAll();
		return owners;
	}

	@GetMapping("/owner/{id}")
	public ResponseEntity getOwner(@PathVariable Integer id) {
		return ResponseEntity.of(service.findById(id));

	}

}
