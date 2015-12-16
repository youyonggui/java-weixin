package com.yyg.wxServiceUtil;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.com.sources.pojo.Loginuser;


public class checkPrimary {
	//cookie用户名
	private static final String ADMIN_COOKIE_NAME = "myweixinAdmin";
	//cookie密码
	private static final String PWD_COOKIE_NAME = "myweixinpwd";
	//判断用户权限
	public static int checkPrim(HttpServletRequest request) throws UnsupportedEncodingException{
		//没有该用户
		int prim = -1;
		
		Cookie[] cookies = request.getCookies();
		if(null !=	cookies){
			String admin = "";
			String pwd = "";
			//查找cookie是否存在
			for(Cookie co : cookies){
				if(co.getName().equals(ADMIN_COOKIE_NAME)){
					admin = URLDecoder.decode(co.getValue(),"UTF-8");
				}
				if(co.getName().equals(PWD_COOKIE_NAME)){
					pwd = URLDecoder.decode(co.getValue(),"UTF-8");
				}
			}
			System.out.println(admin +"==>"+ pwd);
			//cookie 存在时查找遍历
			if(null!=admin&&null!=pwd&&""!=admin&&""!=pwd){
				Loginuser user = checkAdmin.check(admin, pwd);
				if(user != null){
					prim = user.getPrimary();
					System.out.println(user.toString());
				}else{
					System.out.println("hello");
				}
			}
		}
		
		return prim;
	}

}
