package com.yyg.wxServiceUtil;

import java.util.List;

import org.com.sources.pojo.Loginuser;


import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yyg.ServiceInterf.ServiceM;

public class checkAdmin {
	
	public static Loginuser check(String user,String pass)
	{
		Loginuser admin = null;
		String hql = "from Loginuser where name=? and password=?";
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		ServiceM sm = (ServiceM)ac.getBean("Loginuser");
		List<Object> list = sm.selectGet(hql,user,pass);
		if(!list.isEmpty()){
			for(Object obj : list){
				admin = (Loginuser)obj;
			}
		}
		return admin;
	}

}
