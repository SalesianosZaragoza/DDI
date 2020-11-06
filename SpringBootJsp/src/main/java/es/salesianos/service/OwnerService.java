package es.salesianos.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import es.salesianos.model.Owner;
import es.salesianos.repository.OwnerRepository;
import es.salesianos.utils.DateConverter;

@Service("ownerService")
@Profile("PRO")
public class OwnerService implements OwnerServiceInterface{
	
	@Autowired
	private OwnerRepository repository;
	
	@Autowired
	private DateConverter converter;

	private static final Logger LOGGER = LogManager.getLogger(OwnerService.class);
	
	public void save(Owner ownerFormulario) {
		Owner userInDatabase = repository.search(ownerFormulario);
		if(null == userInDatabase){
			repository.insert(ownerFormulario);
		}else{
			repository.update(ownerFormulario);
		}

	}
	
	
	public void addOwner(Owner owner) {
		repository.insert(owner);
	}

	
	public void deleteOwner(Integer codOwner) {
		repository.delete(codOwner);
	}
	
	public Owner search(Integer codOwner) {
		return repository.searchByCodOwner(codOwner);
		
	}

	public OwnerRepository getRepository() {
		return repository;
	}

	public void setRepository(OwnerRepository repository) {
		this.repository = repository;
	}
	
	private List<Owner> listAllOwners() {
		LOGGER.info("ESTAS EN EL ListService");
		return repository.searchAll();
	}

	@Override
	public void insertOrUpdate(Owner owner) {
		repository.update(owner);
	}

	@Override
	public List<Owner> listAll() {
		return listAllOwners();
	}

	@Override
	public Optional findById(Integer id) {
		return Optional.of(repository.searchByCodOwner(id));
	}
	
	
	

}
