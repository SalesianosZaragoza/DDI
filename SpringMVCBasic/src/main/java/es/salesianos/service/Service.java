package es.salesianos.service;

import java.util.List;

import es.salesianos.model.CookingType;

public interface Service {

	public void insert(CookingType cookingType);

	public List<CookingType> listAll();

}
