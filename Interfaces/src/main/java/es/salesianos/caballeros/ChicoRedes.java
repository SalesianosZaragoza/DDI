package es.salesianos.caballeros;

import es.salesianos.damas.Mujeres;

public class ChicoRedes extends Informatico {

	@Override
	public boolean aceptar(Mujeres mujer) {
		return false;
	}
	
	@Override
	public void hablar(Mujeres mujer) {
		System.out.println("estoy hablando con " + mujer.getClass().getName());
	}

}
