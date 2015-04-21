package com.anas.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
	public static Date parsedatum(String dateInString){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd");
		//String dateInString = "1982-08-31";
		Date date = null;
		try {
			date = sdf.parse(dateInString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
		
	}

}
