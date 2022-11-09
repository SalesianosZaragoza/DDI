package es.salesianos.edu.model;

public class Record {
	private String initial;
	private String name;
	private int tries;
	private String message;
	
	
	public Record() {
	}
	
	public Record(String initial, String name, int tries) {
		super();
		this.initial = initial;
		this.name = name;
		this.tries = tries;
	}

	public int getTries() {
		return tries;
	}

	public void setTries(int tries) {
		this.tries = tries;
	}

	public String getInitial() {
		return initial;
	}

	public void setInitial(String initial) {
		this.initial = initial;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
