package es.salesianos.edu.model;

public class UserAnswer {
	private String[] answer;
	private String reason;
	private String message;

	public String[] getAnswer() {
		return answer;
	}

	public void setAnswer(String[] answer) {
		this.answer = answer;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
}
