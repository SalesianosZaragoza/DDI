package es.salesianos.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User {

	private String name;
	private String course;
	private Date dateOfBirth;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {

		try {
			this.dateOfBirth = sdf.parse(dateOfBirth);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

}
