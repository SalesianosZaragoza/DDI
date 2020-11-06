package es.salesianos.damas;

import es.salesianos.caballeros.Hombres;
import es.salesianos.caballeros.Informatico;
import es.salesianos.caballeros.Presumido;

public class Lanzadas implements Mujeres, Presumido {

	@Override
	public void bailan(Hombres hombre) {
		if(hombre instanceof Informatico) {
			throw new RuntimeException();
		}
		System.out.println("estoy bailando con "+hombre.getClass().getName());
		
	}

	@Override
	public boolean ignoran(Hombres hombre) {
		return false;
	}

	@Override
	public void presumen(Mujeres mujer, Hombres hombre) {
		System.out.println(this.getClass().getName() + " estoy presumiendo delante de la gente");
		
	}



}
