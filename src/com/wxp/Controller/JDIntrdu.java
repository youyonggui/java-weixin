package com.wxp.Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.com.sources.pojo.Project;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yyg.ServiceInterf.ServiceM;
import com.yyg.struts.respMsg;

import net.sf.json.JSONObject;

public class JDIntrdu {
	private static ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	//更新基地信息
	public static void updateJDInfo(respMsg respM,HttpServletRequest request)
	{
		//String query = "insert into intrduction(jj_content,jj_time) values(\""+request.getParameter("newIntrduction")+"\",now());";
		ServiceM sm = (ServiceM)ac.getBean("Project");
		if(null == sm){
			respM.setMsg("配置出错！");
			respM.setSuccess(false);
			return;
		}
		Date date = new Date();
		long time = date.getTime();
		Project project = new Project();
		project.setContent(request.getParameter("content"));
		project.setCTime(new Timestamp(time));
		sm.save(project);
		respM.setMsg("success");
		respM.setSuccess(true);
			
	}
	//查询基地信息
	public static void selectJDInfo(respMsg respM)
	{
		ServiceM sm = (ServiceM)ac.getBean("Project");
		//升序排序查找最新的一条
		//String query = "select * from intrduction order by jj_time desc limit 0,1;";
		String hql = "from Project order by CTime desc";
		List<Object> list = sm.selectOrder(hql, 0, 1);
		if(null != list){
			Project project = (Project)list.get(0);
			respM.setMsg(JSONObject.fromObject(project).toString());
			respM.setSuccess(true);
		}else{
			respM.setMsg("没有找到任何数据");
			respM.setSuccess(false);
		}
	}

}
