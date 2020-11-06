package es.salesianos.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Actor;
import es.salesianos.model.Director;
import es.salesianos.model.Pelicula;
import es.salesianos.repository.Repository;

public class Service {


	private Repository repository = new Repository();

	public List<Actor> selectAllActor() {
			return repository.selectAllActor();
	}
	public List<Director> selectAllDirector() {
		return repository.selectAllDirector();
	}
	public List<Pelicula> selectAllPelicula() {
		return repository.selectAllPelicula();
	}
	
	public void insert(Actor actor) {
		repository.insert(actor);

	}
	public void insert(Pelicula pelicula) {
		repository.insert(pelicula);
		
	}
	public void insert(Director director) {
		repository.insert(director);
	}
	
	public void delete(Actor actor) {
		repository.delete(actor);

	}
	public void delete(Pelicula pelicula) {
		repository.delete(pelicula);
		
	}
	public void delete(Director director) {
		repository.delete(director);
	}

}
