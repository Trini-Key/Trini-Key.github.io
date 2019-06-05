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


public class FeedRead {
	/*This is the first form of my function. This function takes a URL in the form of a String then
	 * searches that URL for the latest date of activity on the RSS feed. It does this by searching 
	 * the <pubDate> tag. once it finds the tag it will return the date. just to see if that works
	 * next steps would be creating a function that would take todays date and subtract from the RSS 
	 * feed latest date and see how many days it has been inactive. 
	 * 
	 * Not the final form of my function just a starting point.
	 */
	public static String feedActivity(String urlAddress) {
		try {
			URL rssUrl = new URL(urlAddress);
			BufferedReader in = new BufferedReader(new InputStreamReader(rssUrl.openStream()));

			String sourceCode = "";
			String line;

			while ((line = in.readLine()) != null) {
				//if the line in the page contains <pubDate> then carry out the rest of statements
				if (line.contains("<pubDate>")) {
					//set the first position to the index of <pubDate>
					int firstPos = line.indexOf("<pubDate>");
					//temporary string is equal to substring of the line from the position of the index of <pubDate> (inclusive)
					String temp = line.substring(firstPos);
					//remove <pubDate> from the string
					temp = temp.replaceAll("<pubDate>", "");
					//take care of the closing tag by setting the last position to its index
					int lastPos = temp.indexOf("</pubDate>");
					//remove the closing tag by creating substring that starts at 0 to the index set by lastPos (exclusive)
					temp = temp.substring(0, lastPos);
					//return the date stored as a string. The date will most likely be the latest activity on the feed
					sourceCode += temp + "\n";
				}
			}
			in.close();
			return sourceCode;
		} catch (MalformedURLException mue) {
			System.out.println("Malformed URL");
		} catch (IOException ioe) {
			System.out.println("Problem reading the contents");
		}
		//return null if the process fails and skips the try catch block.
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// next step I will replace this string with a dictionary and activate the method to go through and find all the dates.
		System.out.println(feedActivity("http://rss.cnn.com/rss/edition.rss"));
	}

}
