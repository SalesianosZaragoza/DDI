package spring;

import java.util.List;

public class Teclado {

	private String idioma;
	private List<Tecla> letras;

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public List<Tecla> getLetras() {
		return letras;
	}

	public void setLetras(List<Tecla> letras) {
		this.letras = letras;
	}
	
}
