package utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class DateTimeMethods {
	
	
	/**
	 * Get todays date
	 * @param Date Format e.g. MM/dd/yyyy, ddMMMyyyy, ddMMMyyyyhhmm (d = date, M = Month, m = minute, y = year, s=seconds) 
	 * @return returns the date in specified format 
	 */
	public static String getCurrentDate(String dateFormat){
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		Calendar calendar = Calendar.getInstance();
		return sdf.format(calendar.getTime());
	}
	
}
