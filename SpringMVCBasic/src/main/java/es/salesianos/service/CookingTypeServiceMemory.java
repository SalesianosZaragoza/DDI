package es.salesianos.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import es.salesianos.model.CookingType;

@Service
@Profile("memory")
public class CookingTypeServiceMemory implements es.salesianos.service.Service {

	private static Logger log = LogManager.getLogger(CookingTypeServiceMemory.class);

	private List<CookingType> cookingTypes = new ArrayList<>();

	@Override
	public void insert(CookingType cookingType) {
		log.info("inserting new cookingType:" + cookingType);
		cookingTypes.add(cookingType);
	}

	@Override
	public List<CookingType> listAll() {
		for (CookingType cookingType : cookingTypes) {
			log.info("showing cookingType:" + cookingType);
		}
		return cookingTypes;
	}


}
