package es.salesianos.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Owner {
	private Integer codOwner;
	private String name;
	private String surname;
	private List<Pet> mascotas = new ArrayList<Pet>();
	
	public void setMascotas(List<Pet> mascotas) {
		this.mascotas=mascotas;
	}
	
	public List<Pet> getMascotas() {
		return mascotas;
	}
	
	
	public void addToListPet(Pet pet) {
		mascotas.add(pet);
	}

	public void setName(String name) {
		this.name=name;
	}

	public String getName() {
		return name;
	}
	
	public void setCodOwner(Integer codOwner) {
		this.codOwner=codOwner;
	}
	
	public Integer getCodOwner() {
		return codOwner;
	}

	public void setSurname(String surname) {
		this.surname=surname;
	}
	
	public String getSurname() {
		return surname;
	}

	@Override
	public String toString() {
		return "User [codOwner="+codOwner+ "name=" + name + ", surname=" + surname + "]";
	}
	

}
