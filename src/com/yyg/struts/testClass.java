package com.yyg.struts;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sf.json.JSONObject;


public class testClass {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws UnsupportedEncodingException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedEncodingException {
		// TODO Auto-generated method stub
		
		String str = "hello	world!how are you"
				+ "i am fine!";
		
		Pattern p = Pattern.compile("\\s|\t|\r\n|\r|\n|");
		
		Matcher m = p.matcher(str);
		
		System.out.println(m.replaceAll(""));
		
		/*
		respMsg rm = new respMsg();
		rm.setSuccess(true);
		rm.setMsg("hello");
		
		System.out.println(rm.getMsg().getClass());
		
		System.out.println(JSONObject.fromObject(rm).toString());
		
		Class<?> c = Class.forName("Struct.Class.respMsg");
		
		//Object obj = c.newInstance();
		
		Field[] fields=c.getDeclaredFields();//拿到数据成员
		
		Method[] methods=c.getMethods();//拿到函数成员
		
		JSONObject obj = JSONObject.fromObject(rm);
		
		System.out.println(fields.length);
		
		for(Field f : fields){
			String key = f.getName();
			System.out.println("该类的内部变量有:"+f.getName()+"="+obj.getString(key));
		}
		for(Method m : methods) {
			System.out.println("该类的方法有:"+m.getName());
		}
		
		String url = "http://111.78.92.64?helloyou=you";
		
		System.out.println(java.net.URLEncoder.encode(url,"utf-8"));
		
	*/
	}

}
