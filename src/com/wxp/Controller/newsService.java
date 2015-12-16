package com.wxp.Controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.com.sources.pojo.Images;
import org.com.sources.pojo.News;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yyg.ServiceInterf.ServiceM;
import com.yyg.struts.respMsg;

public class newsService {
	private static final String TAB_NEWS = "news";
	/**
	 * 
	 */
	//定义一个私有常量
	private static ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	//发布新闻
	public static Integer publicNews(News news){
		ServiceM sm = (ServiceM)ac.getBean("News");
		Integer id = sm.save(news);
		
		//如果新闻没有发布成功，就不用保存图片，马上退出
		if(id == -1){
			return -1;
		}
		News n = (News)sm.selectGet(News.class, id);
		Images img = new Images();
		Iterator<Images> it = news.getImageses().iterator();
		if(it.hasNext()){
			img = it.next();
			img.setNews(n);
			Date date = new Date();
			img.setCTime(new Timestamp(date.getTime()));
			sm.save(img);
		}
		return 1;
	}
	//发布新闻
	public static void publicNews(respMsg respM,HttpServletRequest request) throws UnsupportedEncodingException{
		String title = request.getParameter("n_title");
		String content = request.getParameter("n_content");
		String pictrue = request.getParameter("n_pictrue");
		String author = "";
		System.out.println("content="+request.getParameter("n_title"));
		System.out.println("content="+content);
		Cookie[] cookies = request.getCookies();

		if(null != cookies){
			for(Cookie co : cookies){
				if(co.getName().equals("myweixinAdmin"))
				{
					author = co.getValue();
				}
			}
		}
		 if(null == author || "" == author){
			 respM.setMsg("没有找到用户");
			 respM.setSuccess(false);
			 return;
		 }
		//获取数据
		ServiceM sm = (ServiceM)ac.getBean("News");
		if(null == sm){
			respM.setMsg("没有入库成功！");
			respM.setSuccess(false);
			return;
		}
		Date date = new Date();
		long time = date.getTime();
		News news = new News(title,author,new Timestamp(time));
		news.setContent(content);
		sm.save(news);
		respM.setMsg("success");
		respM.setSuccess(true);

	}
	//删除新闻
	public static void deleteNews(respMsg respM,HttpServletRequest request){
		Integer id = Integer.parseInt(request.getParameter("id"));
		ServiceM sm = (ServiceM)ac.getBean("News");
		News news = (News) sm.selectGet(News.class,id);
		if(null != news){
			sm.delete(news);
			respM.setMsg("success");
			respM.setSuccess(true);
			System.out.println("新闻"+id+"被删除。。。");
		}else{
			respM.setMsg("id="+id+"的新闻没有找到！");
			respM.setSuccess(false);
		}
	}
	//查看新闻
	public static void selectNews(respMsg respM,HttpServletRequest request){
		String hql = "from News order by CTime desc";
		String msg = "";
		String maxResult = request.getParameter("rows");
		maxResult = ("" != maxResult && maxResult != null) ? maxResult : "10";
		ServiceM sm = (ServiceM)ac.getBean("News");
		List<Object> list = sm.selectOrder(hql, 0, Integer.parseInt(maxResult));
		if(null != list){
			News news = null;
			for(Object n : list){
				news = (News)n;
				msg += news.toString() + ",";
			}
			msg = "[" + msg.substring(0, msg.length()-1) + "]";
			respM.setMsg(msg);
			respM.setSuccess(true);
		}else{
			respM.setMsg("没有数据");
			respM.setSuccess(false);
		}
	}
	
	public static void selectContent(respMsg respM,int id){
		//String query = "select n_content from news where id="+id+";";
		ServiceM sm = (ServiceM)ac.getBean("News");
		News news = (News)sm.selectGet(News.class, id);
		String content = news.getContent();
		if(null != content || "" != content){
			respM.setMsg(content);
			respM.setSuccess(true);
		}else{
			respM.setMsg("没有这个条目的数据！");
			respM.setSuccess(false);
		}
	}

}
