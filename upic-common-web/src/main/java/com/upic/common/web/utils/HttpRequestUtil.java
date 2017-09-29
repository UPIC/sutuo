package com.upic.common.web.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;

public class HttpRequestUtil {
	public static String httpRequest(String requesturl,String connType) throws UnsupportedEncodingException {
		StringBuffer buffer = new StringBuffer();
		try {
			URL url = new URL(requesturl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod(connType);
			conn.connect();
			//
			InputStream is = conn.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			BufferedReader br = new BufferedReader(isr);
			
			String line = null;
			while ((line = br.readLine()) != null) {
				buffer.append(line);
			}
			br.close();
			isr.close();
			is.close();
			conn.disconnect();
			return URLDecoder.decode(buffer.toString(),"utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

	public static CharSequence urlEncode(String source, String encode) {
		 String result = source;  
	        try {  
	            result = java.net.URLEncoder.encode(source,encode);  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	            return "0";  
	        }  
	        return result;  
	}
}
