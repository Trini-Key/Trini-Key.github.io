/*Keiron Jerome
 * Metabolon Coding Challenge
 * 
 * Task: Given a Dictionary keyed by Company and valued by RSS feed url, write a function that 
 * determines which companies had no activity for a given number of days. 
 * 
 * Assumption: I'm assuming that this means companies that had no activity for a given number of days from 
 * their latest activity to the current date.
 */
package readfeed;

import java.io.*;
import java.net.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class FeedRead {

	// this will take the date passed in and convert it to another format
	public static LocalDate formatDate(String strDate) throws ParseException {
		String date = strDate;
		// set the format of the date. i.e. MON 01 JUN 2019 21:54:23 GMT
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE, d MMM yyyy", Locale.ENGLISH);
		LocalDate dateTime = LocalDate.parse(date, formatter);

		return dateTime;
	}

	/*
	 * this form of the method take a map as the dictionary. It has a Key of type
	 * String and Value of collection of Strings. It should iterate over all the
	 * keys and their values
	 */
	public static String feedActivity(Map<String, List<String>> dictionary, int daysInactive) {
		try {
			// this variable is meant to hold the difference of days between current day and
			// last day of activity of a feed.
			int diffDay = 0;
			// Iterate over the dictionary keys and all its values I assume are held in a
			// list.
			for (String name : dictionary.keySet()) {
				List<String> url = dictionary.get(name);
				for (int i = 0; i < url.size(); i++) {
					URL rssUrl = new URL(url.get(i));

					BufferedReader in = new BufferedReader(new InputStreamReader(rssUrl.openStream()));

					String sourceCode = "";
					String line;
					String inactiveFeed = "";
					while ((line = in.readLine()) != null) {
						// if the line in the page contains <pubDate> then carry out the rest of
						// statements
						if (line.contains("<pubDate>")) {
							// set the first position to the index of <pubDate>
							int firstPos = line.indexOf("<pubDate>");
							// temporary string is equal to substring of the line from the position of the
							// index of <pubDate> (inclusive)
							String temp = line.substring(firstPos);
							// remove <pubDate> from the string
							temp = temp.replaceAll("<pubDate>", "");
							// take care of the closing tag by setting the last position to its index
							int lastPos = temp.indexOf("</pubDate>");
							// remove the closing tag by creating substring that starts at 0 to the index
							// set by lastPos (exclusive)
							temp = temp.substring(0, lastPos);
							// return the date stored as a string. The date will most likely be the latest
							// activity on the feed
							sourceCode += temp + "\n";
							// supposed to capture the difference of days
							diffDay = LocalDate.now().getDayOfYear() - formatDate(sourceCode).getDayOfYear();

							if (diffDay >= daysInactive) {
								// System.out.println(x);
							}
						}
					}
					inactiveFeed += name + " inactive for " + " days";
					in.close();
					return sourceCode;
				}
			}
		} catch (MalformedURLException mue) {
			System.out.println("Malformed URL");
		} catch (IOException ioe) {
			System.out.println("Problem reading the contents");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("Date calculation error");
			e.printStackTrace();
		}
		// return null if the process fails and skips the try catch block.
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// next step I will replace this string with a dictionary and activate the
		// method to go through and find all the dates.
		// System.out.println(feedActivity("http://rss.cnn.com/rss/edition.rss"));

	}

}
