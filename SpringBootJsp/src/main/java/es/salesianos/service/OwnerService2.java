package es.salesianos.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import es.salesianos.model.Owner;

@Service("ownerService")
@Profile("dummy")
public class OwnerService2 implements OwnerServiceInterface {
	
	public void save(Owner owner) {
		System.out.println("salvando:"+owner);
	}

	public void addOwner(Owner owner) {
		System.out.println("addowner:"+owner);
	}

	@Override
	public void insertOrUpdate(Owner owner) {
		System.out.println("addowner:" + owner);
	}

	@Override
	public List<Owner> listAll() {
		System.out.println("listAll:");
		return Collections.EMPTY_LIST;
	}

	@Override
	public Optional findById(Integer id) {
		System.out.println("findById:" + id);
		return Optional.empty();
	}

	@Override
	public void deleteOwner(Integer codOwner) {
		System.out.println("deleteOwner:");

	};
	

}
