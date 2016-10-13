package es.salesianos.utils;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class DateConverterTest {

	DateConverter converter = new DateConverter();
	
	@Test
	public void test() {
		Assert.assertEquals(10, converter.getAge("11-02-2006").intValue());
		
	}

}
