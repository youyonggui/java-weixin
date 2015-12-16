package com.yyg.wxServiceUtil;

import java.util.Random;

public class randomModel {
	
	private static Random random = new Random();
	/**
	public static void main(String[] args) {
		System.out.println(randomString(7));
		System.out.println(randomLower(7));
		System.out.println(randomUpper(7));
		System.out.println(randomNumber(7));
	}
	*/
	
	//随机字符数组  
    private static char[] charSequence = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
    private static char[] lower = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private static char[] upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private static char[] number = "0123456789".toCharArray();

    //获取随机字符串
    public static String randomString(int digits){
    	StringBuffer sb = new StringBuffer();
    	String ch = "";
    	for(int i=0;i<digits; i++){
	    	int index = random.nextInt(charSequence.length);
			ch = String.valueOf(charSequence[index]);
			
			sb.append(ch);
    	}
    	return sb.toString();
    }
    //产生随机的小写字符串
    public static String randomLower(int digits){
    	StringBuffer sb = new StringBuffer();
    	String ch = "";
    	for(int i=0;i<digits; i++){
	    	int index = random.nextInt(lower.length);
			ch = String.valueOf(lower[index]);
			sb.append(ch);
    	}
    	return sb.toString();
    }
    //大写
    public static String randomUpper(int digits){
    	StringBuffer sb = new StringBuffer();
    	String ch = "";
    	for(int i=0;i<digits; i++){
	    	int index = random.nextInt(upper.length);
			ch = String.valueOf(upper[index]);
			sb.append(ch);
    	}
    	return sb.toString();
    }
    //产生数字随机数
    public static String randomNumber(int digits){
    	StringBuffer sb = new StringBuffer();
    	String ch = "";
    	for(int i=0;i<digits; i++){
	    	int index = random.nextInt(10);
			ch = String.valueOf(number[index]);
			sb.append(ch);
    	}
    	return sb.toString();
    }
}
