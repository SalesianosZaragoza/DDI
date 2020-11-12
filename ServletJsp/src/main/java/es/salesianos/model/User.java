package es.salesianos.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User {

	private String name;
	private Integer course;
	private Date dateOfBirth;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {

		try {
			//yyyy-MM-dd
			this.dateOfBirth = sdf.parse(dateOfBirth);
		} catch (ParseException e) {
			this.dateOfBirth = new Date();
			//throw new RuntimeException(e);
		}
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", course=" + getCourse() + ", dateOfBirth=" + dateOfBirth + ", sdf=" + sdf + "]";
	}

	public Integer getCourse() {
		return course;
	}

	public void setCourse(Integer course) {
		this.course = course;
	}
	
	

}
