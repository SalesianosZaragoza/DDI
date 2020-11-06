package es.salesianos.caballeros;

import java.io.IOException;

import es.salesianos.damas.Mujeres;

public abstract class Informatico implements Hombres {
	@Override
	public void hablar(Mujeres mujer)   {
			boolean error = false;
			try {
				if(mujer.ignoran(this)) {
					throw new IOException();
				}
			} catch (IOException e) {
				throw new RuntimeException(e);
			}finally {
				error = true;
			}
			//throw new IllegalArgumentException();
	}
}
