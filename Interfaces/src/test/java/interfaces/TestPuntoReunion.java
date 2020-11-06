package interfaces;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import es.salesianos.caballeros.ChicoRedes;
import es.salesianos.caballeros.Futbolista;
import es.salesianos.caballeros.Hombres;
import es.salesianos.caballeros.Informatico;
import es.salesianos.caballeros.Programador;
import es.salesianos.damas.Calladas;
import es.salesianos.damas.Lanzadas;
import es.salesianos.damas.Mujeres;
import es.salesianos.meetingPoint.Clase;
import es.salesianos.meetingPoint.PuntoReunion;

public class TestPuntoReunion {

	private PuntoReunion reunion;	
	private List<Hombres> listHombres;
	private List<Mujeres> listMujeres;
	
	

	public void initialize() {
		reunion = new Clase();
		listHombres = new ArrayList<>();
		listHombres.add(new Futbolista());
		listHombres.add(new ChicoRedes());
		listHombres.add(new Programador());
		listHombres.add(new Informatico() {
			
			@Override
			public boolean aceptar(Mujeres mujer) {
				return true;
			}
		});
		
		listHombres.add(new Hombres() {
			
			@Override
			public void hablar(Mujeres mujer) {
						
			}
			
			@Override
			public boolean aceptar(Mujeres mujer) {
				return false;
			}
		});
		
		listMujeres = new ArrayList<>();
		listMujeres.add(new Calladas());
		listMujeres.add(new Lanzadas());
		
		
	}
	
	@Test
	public void testHombresyMujeres() {
		initialize();
		try {
			reunion.reunen(listHombres, listMujeres);
		} catch (Exception e) {
		}
	}

}
