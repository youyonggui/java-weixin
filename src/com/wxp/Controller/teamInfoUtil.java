package com.wxp.Controller;

import java.util.Iterator;
import java.util.List;

import org.com.sources.pojo.Images;
import org.com.sources.pojo.News;
import org.com.sources.pojo.UInformation;
import org.com.sources.pojo.UIntrduction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yyg.ServiceInterf.ServiceM;
import com.yyg.struts.respMsg;


public class teamInfoUtil{
	
	private static ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	public static respMsg moreOptionClient(int position,respMsg respmsg){
		//respMsg respmsg = new respMsg();
		//System.out.println("position==="+position);
		String a = null;
		String b = "";
		System.out.println("a="+a+" b="+b);
		//String query = "select t_id,t_name,t_pictureURL,t_intrduction from teamInfo order by t_name limit " +position+ ",5;";
		String hql ="from UInformation order by status desc";
		String str = "";
		ServiceM sm = (ServiceM)ac.getBean("UInformation");
		List<Object> list = sm.selectOrder(hql, position, 5);
		if(!list.isEmpty()){
			UInformation uInformation = null;
			for(Object obj : list){
				String intrduction = "";
				String image = "";
				uInformation = (UInformation)obj;
				Iterator<UIntrduction> it = uInformation.getUIntrductions().iterator();
				Iterator<Images> imgs = uInformation.getImageses().iterator();
				if(it.hasNext()){intrduction = it.next().getIntrduction();}
				if(imgs.hasNext()){image = imgs.next().getVals();}
				str += "{"+'"'+"id"+'"'+":"+uInformation.getId()+",";
				str += '"'+"schoolId"+'"'+":"+'"'+uInformation.getSchoolId()+'"'+",";
				str += '"'+"name"+'"'+":"+'"'+uInformation.getName()+'"'+",";
				str += '"'+"image"+'"'+":"+'"'+image+'"'+",";
				str += '"'+"intrduction"+'"'+":"+'"'+intrduction+'"';
				str +="},";
			}
			str = "[" + str.substring(0, str.length()-1) + "]";
			respmsg.setSuccess(true);
			respmsg.setMsg(str);
		}else{
			respmsg.setSuccess(false);
			respmsg.setMsg("加载完成");
		}
		
		return respmsg;
	}
	
	public static boolean moreNews(int position,respMsg respmsg){
		boolean bool = false;
		ServiceM sm = (ServiceM)ac.getBean("News");
		String msg = "";
		String hql = "from News order by CTime desc";
		List<Object> list = sm.selectOrder(hql, position, 5);
		if(!list.isEmpty()){
			News n = null;
			for(Object obj : list){
				n = (News)obj;
				msg += n.toString() + ",";
			}
			msg = "[" + msg.substring(0, msg.length()-1) + "]";
			System.out.println(msg);
			respmsg.setMsg(msg);
			respmsg.setSuccess(true);
		}else{
			respmsg.setMsg("没有更多的数据！");
			respmsg.setSuccess(false);
		}
		return bool;
	}

}
