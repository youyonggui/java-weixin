package com.wxp.Controller;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.com.sources.pojo.UInformation;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.ResolvableType;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.ui.context.support.UiApplicationContextUtils;

import com.yyg.ServiceInterf.ServiceM;
import com.yyg.struts.respMsg;


public class teamSqlInfo {
	
	private static ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	public static void updateTeamInfo(respMsg respM,HttpServletRequest request)
	{//更新成员信息
		String t_name = request.getParameter("t_name");
		long schoolId = Long.parseLong(request.getParameter("schoolId"));
		String t_sexy = request.getParameter("t_sexy");
		String t_class = request.getParameter("t_class");
		String t_email = request.getParameter("t_email");
		String t_pictureURL = request.getParameter("t_pictrues");
		String t_intrduction = request.getParameter("t_intrduction");
		UInformation ui = (UInformation)ac.getBean("UInformation");
		ServiceM sm = (ServiceM)ui;
		ui.setSchoolId(schoolId);
		ui.setSexy(t_sexy);
		ui.setName(t_name);
		Date date = new Date();
		long time = date.getTime();
		ui.setCTime(new Timestamp(time));
		//ui.setBirthday(birthday);
		sm.save(ui);
	}
	//删除成员信息
	public static void teamInfoDel(respMsg respmsg,HttpServletRequest request)
	{
		Integer id = Integer.parseInt(request.getParameter("id"));
		//String query = "delete from teamInfo where t_id='"+t_id+"';";
		//System.out.println(query);
		ServiceM sm = (ServiceM)ac.getBean("UInformation");
		UInformation ui = (UInformation)sm.selectGet(UInformation.class, id);
		if(null != ui){
			sm.delete(ui);
			respmsg.setSuccess(true);
			respmsg.setMsg("success");
		}else{
			respmsg.setSuccess(false);
			respmsg.setMsg("没有指定的数据！");
		}
		
	}
	public static void teamInfoSelect(respMsg respmsg,HttpServletRequest request)
	{	//查找成员信息
		//String position = request.getParameter("position");
		String hql = "from UInformation order by status desc";
		String msg = "";
		
		int first = Integer.parseInt((""!=request.getParameter("page")&&null!=request.getParameter("page"))?request.getParameter("page"):"0");
		int max = Integer.parseInt((""!=request.getParameter("row")&&null!=request.getParameter("row"))?request.getParameter("row"):"15");
		//通过ServiceM接口连接业务层
		ServiceM sm = (ServiceM)ac.getBean("UInformation");
		List<Object> list = sm.selectOrder(hql, first, max);
		if(null != list){
			UInformation ui = null;
			for(Object obj : list){
				ui = (UInformation)obj;
				msg += ui.toString() + ",";
			}
			msg = "[" + msg.substring(0, msg.length()-1) + "]";
			respmsg.setMsg(msg);
			respmsg.setSuccess(true);
		}else{
			respmsg.setMsg("数据库请求失败！");
			respmsg.setSuccess(false);
		}

	}
}
