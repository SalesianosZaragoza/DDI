package es.salesianos.damas;

import es.salesianos.caballeros.Calzonazos;
import es.salesianos.caballeros.Hombres;

public class Feministas implements Mujeres {

	@Override
	public void todo() {
		System.out.println("Yo puedo con todo porque yo lo valgo");
	}

	@Override
	public void isRechazan(Hombres hombre) {
		throw new RuntimeException("No quiero hombres en mi vida");
	}

	@Override
	public void emparejan(Hombres hombre) {
		if (hombre instanceof Calzonazos) {
			System.out.println("chicas me voy a casar");
		}
	}

}
