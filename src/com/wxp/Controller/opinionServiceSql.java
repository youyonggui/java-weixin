package com.wxp.Controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.com.sources.pojo.Opinions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yyg.ServiceInterf.ServiceM;
import com.yyg.struts.respMsg;


public class opinionServiceSql {
	
	private static ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	public static void opinSelect(respMsg respM,HttpServletRequest request){
		String hql = "from Opinions order by CTime desc";
		String msg = "";
		int maxResult = Integer.parseInt((null != request.getParameter("row") && "" != request.getParameter("row")) ? request.getParameter("row") : "15");
		ServiceM sm = (ServiceM)ac.getBean("Opinions");
		List<Object> list = sm.selectOrder(hql, 0, maxResult);
		if(null != list){
			Opinions opinions = null;
			for(Object obj : list){
				opinions = (Opinions)obj;
				msg += opinions.toString() + ",";
			}
			msg = "[" + msg.substring(0, msg.length()-1) + "]";
			respM.setMsg(msg);
			respM.setSuccess(true);
		}else{
			respM.setMsg("目前没有相关的建议反馈");
			respM.setSuccess(false);
		}
	}
	
	public static void opinSave(respMsg respM,HttpServletRequest request){
		String openid = "";
		Cookie[] cookies = request.getCookies();
		
		if(null != cookies){
			for(Cookie co : cookies){
				if(co.getName().equals("openid")){
					openid = co.getValue();
				}
			}
		}
		String  content = request.getParameter("opinion");
		Date date = new Date();
		long time = date.getTime();
		ServiceM sm = (ServiceM)ac.getBean("Opinions");
		Opinions op = new Opinions();
		op.setContent(content);
		op.setOpenid(openid);
		op.setStatus("未阅");
		op.setCTime(new Timestamp(time));
		sm.save(op);
		respM.setMsg("success");
		respM.setSuccess(true);
	}

}
