package es.salesianos.caballeros;

import es.salesianos.damas.Mujeres;

public class Calzonazos implements Hombres {

	@Override
	public boolean isDandoMal() {
		return false;
	}

	@Override
	public void cuidan(Mujeres mujeres) {
		System.out.println("La cuido como un tesoro");
	}

}
