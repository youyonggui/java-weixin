package com.yyg.serviceModel;

import java.util.List;

import org.com.sources.pojo.Project;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yyg.ServiceInterf.ServiceM;

public class WXCoreService {
	
	public static String getProjectIntrduction(){
		String pi = "";
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		ServiceM sm = (ServiceM)ac.getBean("Project");
		String hql = "from Project order by CTmie desc";
		List<Object> list = sm.selectOrder(hql, 0, 1);
		if(null != list){
			Project project = (Project)list.get(0);
			pi = project.getContent();
		}
		return pi;
	}

}
