package es.salesianos.edu.model;

public class GameOptions {
	private int size;
	private int tries;
	private int lefttries;
	private String generatedKey;

	public String getGeneratedKey() {
		return generatedKey;
	}

	public void setGeneratedKey(String generatedKey) {
		this.generatedKey = generatedKey;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getTries() {
		return tries;
	}

	public void setTries(int tries) {
		this.tries = tries;
	}

	public int getLefttries() {
		return lefttries;
	}

	public void setLefttries(int lefttries) {
		this.lefttries = lefttries;
	}
}
