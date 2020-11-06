package es.salesianos.damas;

import es.salesianos.caballeros.Hombres;

public class Calladas implements Mujeres {

	@Override
	public void bailan(Hombres hombre) {
		throw new RuntimeException("no bailo con hombres");
		
	}

	@Override
	public boolean ignoran(Hombres hombre) {
		return true;
	}




}
