package es.salesianos.model;

public class Pet {
	private String name;
	private Integer codOwner;
	
	public void setName(String name) {
		this.name=name;
		
	}

	public String getName() {
		return name;
	}
	
	public Integer getCodOwner() {
		return codOwner;
	}

	public void setCodOwner(Integer codOwner) {
		this.codOwner = codOwner;
	}
}
