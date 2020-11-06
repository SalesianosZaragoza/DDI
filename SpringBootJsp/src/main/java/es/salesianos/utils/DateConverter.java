package es.salesianos.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.stereotype.Component;

@Component
public class DateConverter {

	public Integer getAge(Date date) {
		Integer age = null;
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		Calendar calendarActual = new GregorianCalendar();
		age = calendarActual.get(Calendar.YEAR) - calendar.get(Calendar.YEAR);
		if (calendarActual.get(Calendar.MONTH) < calendar.get(Calendar.MONTH)) {
			age = age - 1;
		}
		if (calendarActual.get(Calendar.MONTH) == calendar.get(Calendar.MONTH)) {
			if (calendarActual.get(Calendar.DAY_OF_MONTH) < calendar.get(Calendar.DAY_OF_MONTH)) {
				age = age - 1;
			}
		}
		return age;
	}

}
