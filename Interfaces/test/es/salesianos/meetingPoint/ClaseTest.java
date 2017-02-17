package es.salesianos.meetingPoint;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import es.salesianos.caballeros.Adonis;
import es.salesianos.caballeros.Calzonazos;
import es.salesianos.caballeros.Hombres;
import es.salesianos.caballeros.Machistas;
import es.salesianos.damas.Feministas;
import es.salesianos.damas.Mujeres;
import es.salesianos.damas.Princesas;

public class ClaseTest {

	Clase clase = new Clase();

	@Test
	public void test() {
		List<Hombres> hombres = new ArrayList<Hombres>();
		List<Mujeres> mujeres = new ArrayList<Mujeres>();
		addHombresToList(hombres);
		addMujerToList(mujeres);
		clase.reunen(hombres, mujeres);
	}

	private void addMujerToList(List<Mujeres> mujeres) {
		mujeres.add(new Princesas());
		mujeres.add(new Feministas());
	}

	private void addHombresToList(List<Hombres> hombres) {
		hombres.add(new Calzonazos());
		hombres.add(new Adonis());
		hombres.add(new Hombres() {

			public boolean isDandoMal() {
				return true;
			}

			public void cuidan(Mujeres mujeres) {

			}
		});
		hombres.add(new Machistas() {
			@Override
			public String seDefine() {
				return null;
			}

		});
	}

}
