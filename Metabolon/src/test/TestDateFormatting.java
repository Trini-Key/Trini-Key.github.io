package test;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;

import org.junit.jupiter.api.Test;

import readfeed.FeedRead;

public class TestDateFormatting {
	
	@Test
	public void shouldFormatDateAndReturnIt() throws ParseException {
		//Given a string date pass to method and return Date object formatted

		
		FeedRead.formatDate("MON 01 JUN 2019 21:54:23 GMT");
		
		
	}

}

