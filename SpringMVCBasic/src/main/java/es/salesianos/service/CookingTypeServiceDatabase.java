package es.salesianos.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import es.salesianos.model.CookingType;
import es.salesianos.repository.CookingTypeRepository;

@Service
@Profile("database")
public class CookingTypeServiceDatabase implements es.salesianos.service.Service {

	private static Logger log = LogManager.getLogger(CookingTypeServiceDatabase.class);

	@Autowired
	private CookingTypeRepository repository;

	@Override
	public void insert(CookingType cookingType) {
		repository.insert(cookingType);
	}

	@Override
	public List<CookingType> listAll() {
		return repository.listAll();
	}

	public CookingTypeRepository getRepository() {
		return repository;
	}

	public void setRepository(CookingTypeRepository repository) {
		this.repository = repository;
	}


}
