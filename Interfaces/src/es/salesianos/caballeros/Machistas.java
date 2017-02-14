package es.salesianos.caballeros;

import es.salesianos.damas.Mujeres;

public class Machistas implements Hombres{

	@Override
	public boolean isDandoMal() {
		return true;
	}

	@Override
	public void cuidan(Mujeres mujeres) {
		throw new RuntimeException("no cuido a una mujer");
	}

}
