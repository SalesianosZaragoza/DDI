package es.salesianos.service;

import java.util.List;
import java.util.Optional;

import es.salesianos.model.Owner;

public interface OwnerServiceInterface {
	
	public void save(Owner ownerFormulario);

	void addOwner(Owner owner);

	public void insertOrUpdate(Owner owner);

	public List<Owner> listAll();

	public Optional<Owner> findById(Integer id);

	public void deleteOwner(Integer codOwner);

}
