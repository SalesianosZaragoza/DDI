package es.salesianos.meetingPoint;

import java.util.List;

import es.salesianos.caballeros.Hombres;
import es.salesianos.caballeros.Reflexion;
import es.salesianos.damas.Mujeres;

public class Clase implements PuntoReunion {

	public void reunen(List<Hombres> hombres, List<Mujeres> mujeres) {

		for (Mujeres mujer : mujeres) {
			for (Hombres hombre : hombres) {
				try {
					if (!hombre.isDandoMal()) {
						mujer.emparejan(hombre);
						hombre.cuidan(mujer);
						System.out.println("son compatibles");
						definir(hombre);
						definir(mujer);

					}
				} catch (Exception e) {
					System.out.println("NO son compatibles");
				}
			}
		}

	}

	private void definir(Object persona) {
		if (persona instanceof Reflexion) {
			System.out.println(((Reflexion) persona).seDefine());

		}
	}

}
