package es.salesianos.caballeros;

import es.salesianos.damas.Mujeres;

public class Futbolista implements Hombres, Presumido {

	@Override
	public void hablar(Mujeres mujer) {
		System.out.println("hablamos con muchas mujeres");
		
	}

	@Override
	public boolean aceptar(Mujeres mujer) {
		return true;
	}

	@Override
	public void presumen(Mujeres mujer, Hombres hombre) {
		if(mujer==null || hombre == null )
			throw new RuntimeException(); 
		
	}

}
