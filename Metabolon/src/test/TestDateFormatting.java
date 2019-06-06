/* Keiron Jerome
 * I never created a Unit test this is my attempt at it to test my method and helpers
 *
 */
package test;

import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;
import readfeed.FeedRead;

public class TestDateFormatting {
	
	@Test
	public void shouldFormatDateAndReturnIt() throws ParseException {
		//Given a string date pass to method and return Date object formatted
		String date = "Sat, 01 Jun 2019 21:54:23 GMT";
		//When
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
		LocalDateTime dateTime = LocalDateTime.parse(date, formatter);
				
		FeedRead.formatDate(date);
		//then
		assertTrue(FeedRead.formatDate(date).getClass().equals(dateTime.getClass()));
		
	}

}

