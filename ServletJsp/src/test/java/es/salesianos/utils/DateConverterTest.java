package es.salesianos.utils;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;

public class DateConverterTest {

	DateConverter converter = new DateConverter();
	
	@Test
	public void test() {
		Date date= new Date(); 
		Calendar calendarActual = new GregorianCalendar();
		calendarActual.setTime(date);
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");

		Calendar calendarTest = calendarActual.getInstance();
		Assert.assertEquals(0, converter.getAge(calendarTest.getTime()).intValue());
		
		calendarTest = calendarActual.getInstance(); 
		calendarTest.add(Calendar.YEAR, -10);
		calendarTest.add(Calendar.MONTH, -1);
		Assert.assertEquals(10, converter.getAge(calendarTest.getTime()).intValue());
		
		calendarTest = calendarActual.getInstance(); 
		calendarTest.add(Calendar.YEAR, -10);
		calendarTest.add(Calendar.MONTH, +1);
		Assert.assertEquals(9, converter.getAge(calendarTest.getTime()).intValue());

		calendarTest = calendarActual.getInstance(); 
		calendarTest.add(Calendar.YEAR, -10);
		calendarTest.add(Calendar.DAY_OF_MONTH, +1);
		Assert.assertEquals(9, converter.getAge(calendarTest.getTime()).intValue());
		
		
		calendarTest = calendarActual.getInstance(); 
		calendarTest.add(Calendar.YEAR, -10);
		calendarTest.add(Calendar.DAY_OF_MONTH, -1);
		Assert.assertEquals(10, converter.getAge(calendarTest.getTime()).intValue());
		
	}

}
