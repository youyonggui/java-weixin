package com.yyg.wxServiceUtil;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class keyDigest {
	
	public static String digestSHA1(String message)
	{
		String SHA = "";
		
		MessageDigest md = null;  
	     try {
			md = MessageDigest.getInstance("SHA-1");
			//加密
	         byte[] digest = md.digest(message.toString().getBytes());  
	         
	         for (int i = 0; i < digest.length; i++) {  
	        	 char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };  
	             char[] tempArr = new char[2];  
	             tempArr[0] = Digit[(digest[i] >>> 4) & 0X0F];  
	             tempArr[1] = Digit[digest[i] & 0X0F];  
	             
	             SHA +=new String(tempArr);
	         }
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}  
		return SHA;
		
	}

}
