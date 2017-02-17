package es.salesianos.caballeros;

import es.salesianos.damas.Mujeres;
import es.salesianos.damas.Princesas;

public class Adonis extends Machistas {

	@Override
	public boolean isDandoMal() {
		return false;
	}

	@Override
	public void cuidan(Mujeres mujeres) {
		if (mujeres instanceof Princesas) {
			System.out.println("la cuido");
		} else {
			super.cuidan(mujeres);
		}

	}

	@Override
	public String seDefine() {
		return getClass().getName();
	}

}
