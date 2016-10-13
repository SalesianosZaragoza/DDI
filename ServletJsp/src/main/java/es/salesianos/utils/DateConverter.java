package es.salesianos.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateConverter {

	public Integer getAge(String paramFecha) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
		try {
			Date date = sdf.parse(paramFecha);
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(date);
			Calendar calendarActual = new GregorianCalendar();
			return calendarActual.get(Calendar.YEAR) - calendar.get(Calendar.YEAR);
		} catch (ParseException e) {
			new RuntimeException(e);
		}
		return null;
	}
	
}
