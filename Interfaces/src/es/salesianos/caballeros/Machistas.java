package es.salesianos.caballeros;

import es.salesianos.damas.Mujeres;

public abstract class Machistas implements Hombres, Reflexion {

	public boolean isDandoMal() {
		return true;
	}

	public void cuidan(Mujeres mujeres) {
		throw new RuntimeException("no cuido a una mujer");
	}

	public abstract String seDefine();

}
