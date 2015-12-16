package com.yyg.wxServiceUtil;

public class URLCode {
	
	public static String urlEncodeUTF8(String str) {
		String result = str;
		
		try {
			result = java.net.URLEncoder.encode(str,"utf-8");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return result;
		
	}

}
