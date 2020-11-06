package es.salesianos.meetingPoint;

import java.util.List;

import es.salesianos.caballeros.Hombres;
import es.salesianos.caballeros.Presumido;
import es.salesianos.damas.Mujeres;

public class Clase implements PuntoReunion {

	public void reunen(List<Hombres> hombres, List<Mujeres> mujeres) {

		for (Mujeres mujer : mujeres) {
			for (Hombres hombre : hombres) {
				if(!mujer.ignoran(hombre)) {
					mujer.bailan(hombre);
				}
				if(hombre.aceptar(mujer)) {
					hombre.hablar(mujer);
				}
				if(hombre instanceof Presumido) {
					presumir((Presumido)hombre, null, mujer);
				}
				if(mujer instanceof Presumido) {
					presumir((Presumido)mujer, hombre, null);
				}
			}
		}

	}

	private void presumir(Presumido persona, Hombres hombre, Mujeres mujer) {
		persona.presumen(mujer, hombre);
	}

}
