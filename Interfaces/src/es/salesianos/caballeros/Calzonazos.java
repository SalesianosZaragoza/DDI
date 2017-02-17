package es.salesianos.caballeros;

import es.salesianos.damas.Mujeres;

public class Calzonazos implements Hombres, Reflexion {

	public boolean isDandoMal() {
		return false;
	}

	public void cuidan(Mujeres mujeres) {
		System.out.println("La cuido como un tesoro");
	}

	public String seDefine() {
		return this.getClass().getName();
	}

}
