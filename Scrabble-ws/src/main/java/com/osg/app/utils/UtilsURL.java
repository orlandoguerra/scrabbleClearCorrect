package com.osg.app.utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class UtilsURL {
	
	public static String KEY_BIGHUGE = "3724f9ab04c482d70967d25d582bfc0e";
	
	public static boolean validateWordBighugelabs(String word) {
		try {
			URL url = new URL("http://words.bighugelabs.com/api/2/"+KEY_BIGHUGE+"/"+word+"/json");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			boolean valid = conn.getResponseCode() == 200;
			conn.disconnect();
			return valid;

		  } catch (MalformedURLException e) {
			e.printStackTrace();
		  } catch (IOException e) {
			e.printStackTrace();
		  }
		
		return true;
		
	}

}
