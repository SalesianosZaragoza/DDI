package es.salesianos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.salesianos.model.Pet;
import es.salesianos.repository.OwnerRepository;
import es.salesianos.utils.DateConverter;

@Service
public class PetService {

	// private Repository repository = new Repository();
	@Autowired
	private OwnerRepository repository;
	private DateConverter converter = new DateConverter();
	
	
	public void addPet(Pet pet) {
		repository.insertPet(pet);
		
	}

	public OwnerRepository getRepository() {
		return repository;
	}

	public void setRepository(OwnerRepository repository) {
		this.repository = repository;
	}
}
