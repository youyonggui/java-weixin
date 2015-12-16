package com.wxp.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.com.sources.pojo.Loginuser;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yyg.wxServiceUtil.checkAdmin;
import com.yyg.wxServiceUtil.keyDigest;

@Controller
public class loginController {
	
	private static final int ERROR_ID = -1;
	@RequestMapping("login.do")
	public void doLoginPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String root = request.getParameter("name");
		String pwd = request.getParameter("password");
		//加密
		String pass = keyDigest.digestSHA1(pwd);
	    //验证
		System.out.println(pass);
		Loginuser user = checkAdmin.check(root, pass);
	
		if(null == user)
		{//错误
			//return "adminError";
			response.sendRedirect("admin/adminError.html?id="+ERROR_ID);
		}else
		{//正确,设置cookie
			Cookie cookie_user = new Cookie("myweixinAdmin",URLEncoder.encode(root));
			Cookie cookie_pwd = new Cookie("myweixinpwd",URLEncoder.encode(pass));
			
			response.addCookie(cookie_user);
			response.addCookie(cookie_pwd);
			response.sendRedirect("admin/index.html?id="+user.getId());
			//return "index?id="+user.getId();
		}
		out.flush();
		out.close();
	}

}
