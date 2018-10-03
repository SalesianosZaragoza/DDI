package es.salesianos.damas;

import es.salesianos.caballeros.Calzonazos;
import es.salesianos.caballeros.Hombres;

public class Feministas implements Mujeres {

	public void todo() {
		System.out.println("Yo puedo con todo porque yo lo valgo");
	}

	public void isRechazan(Hombres hombre) {
		throw new RuntimeException("No quiero hombres en mi vida");
	}

	public void emparejan(Hombres hombre) {
		if (hombre instanceof Calzonazos) {
			System.out.println("chicas me voy a casar");
		}
	}

}
