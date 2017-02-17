package es.salesianos.damas;

import es.salesianos.caballeros.Adonis;
import es.salesianos.caballeros.Hombres;
import es.salesianos.caballeros.Reflexion;

public class Princesas implements Mujeres, Reflexion {

	public void todo() {
		throw new RuntimeException("Soy incapaz de hacer todo");
	}

	public void isRechazan(Hombres hombre) {
		if (hombre instanceof Adonis) {
		} else {
			throw new RuntimeException();
		}
	}

	public void emparejan(Hombres hombre) {

	}

	public String seDefine() {
		return getClass().getName();
	}

}
