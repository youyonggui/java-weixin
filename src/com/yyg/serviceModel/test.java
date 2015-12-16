package com.yyg.serviceModel;


import org.com.sources.pojo.UInformation;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yyg.ServiceInterf.ServiceM;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml"); 
		/*
		ServiceM service = (ServiceM)ac.getBean("News");
		Date date = new Date();
		long time = date.getTime();
		News news = new News("hello","world",new Timestamp(time));
		service.save(news);
		System.out.println(ac);
		*/
		//System.out.println(checkAdmin.check("尤勇贵","admin"));
		ServiceM sm = (ServiceM)ac.getBean("UInformation");
		UInformation uInformation = (UInformation)sm.selectGet(UInformation.class, 1);
		System.out.println(uInformation.toString());
	}

}
