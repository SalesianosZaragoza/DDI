package es.salesianos.meetingPoint;

import java.util.List;

import es.salesianos.caballeros.Hombres;
import es.salesianos.damas.Mujeres;

public class Clase implements PuntoReunion {

	public void reunen(List<Hombres> hombres, List<Mujeres> mujeres) {

		for (Mujeres mujer : mujeres) {
			for (Hombres hombre : hombres) {
				if (!hombre.isDandoMal()) {
					mujer.emparejan(hombre);
					hombre.cuidan(mujer);
				}
			}
		}

	}

}
