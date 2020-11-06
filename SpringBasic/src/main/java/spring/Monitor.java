package spring;

import org.springframework.beans.factory.annotation.Autowired;

public class Monitor {
	
	private Altavoz altavoces;

	public Altavoz getAltavoces() {
		return altavoces;
	}

	public void setAltavoces(Altavoz altavoces) {
		this.altavoces = altavoces;
	}

}
