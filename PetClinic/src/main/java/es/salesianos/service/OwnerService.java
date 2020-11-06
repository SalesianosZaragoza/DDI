package es.salesianos.service;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.salesianos.connection.ConnectionH2;
import es.salesianos.connection.ConnectionManager;
import es.salesianos.model.Owner;
import es.salesianos.model.assembler.OwnerAssembler;
import es.salesianos.repository.Repository;
import es.salesianos.utils.DateConverter;

public class OwnerService {
	
	
	private Repository repository = new Repository();
	private DateConverter converter = new DateConverter();
	private static final Logger LOGGER = LogManager.getLogger(OwnerService.class);
	
	
	public Owner assembleOwnerFromRequest(HttpServletRequest req) {
		return OwnerAssembler.assembleOwnerFrom(req);
	}
	
	public void addOwner(Owner owner) {
		repository.insert(owner);
	}

	public void insertOrUpdate(Owner ownerFormulario) {
		Owner userInDatabase = repository.search(ownerFormulario);
		if(null == userInDatabase){
			repository.insert(ownerFormulario);
		}else{
			repository.update(ownerFormulario);
		}
	}
	
	public void deleteOwner(Integer codOwner) {
		repository.delete(codOwner);
	}
	
	public Owner search(Integer codOwner) {
		return repository.searchByCodOwner(codOwner);
		
	}

	public Repository getRepository() {
		return repository;
	}

	public void setRepository(Repository repository) {
		this.repository = repository;
	}
	
	public List<Owner> listAllOwners() {
		LOGGER.info("ESTAS EN EL ListService");
		return repository.searchAll();
	}
	
	
	

}
