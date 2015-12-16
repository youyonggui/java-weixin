package com.yyg.wxServiceUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.yyg.serviceModel.WXCoreService;


public class menuClickproc extends BaseMessage{
	
	public static String respArticle(NewsMessage newsMessage){
		String respMsg =null;
		
		//图文列表数组
        List<Article> articleList = new ArrayList<Article>();
		
        // 创建多图文消息  
        //NewsMessage newsMessage = new NewsMessage();  
        newsMessage.setCreateTime(new Date().getTime());  
        newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);  
        newsMessage.setFuncFlag(0);
        String content = WXCoreService.getProjectIntrduction();
        //从数据库中找到最新的一条消息取出
 
        Article article = new Article();  
        article.setTitle("南昌大学云计算基地介绍");  
        article.setDescription(content);  
        article.setPicUrl("");  
        article.setUrl("");  

        articleList.add(article);
        
        newsMessage.setArticleCount(1);  
        newsMessage.setArticles(articleList);
        //到此整个newsMessage对象已经整合完毕，开始转换为xml字符串
        respMsg = MessageUtil.newsMessageToXml(newsMessage); 
		return respMsg;
	}
	
	public static String respArticles(NewsMessage newsMessage) throws Exception {
		String respMsg = null;
		
        //图文列表数组
        List<Article> articleList = new ArrayList<Article>();
		
        // 创建多图文消息  
        //NewsMessage newsMessage = new NewsMessage();  
        newsMessage.setCreateTime(new Date().getTime());  
        newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);  
        newsMessage.setFuncFlag(0); 
        
        Article article1 = new Article();  
        article1.setTitle("住在我隔壁的马云");  
        article1.setDescription("1982年，当18岁的马云参加高考的时候，他经历了第一次高考落榜；1983年，马云再次参加高考，再次落榜；直到1984年，第三次高考，勉强被杭州师范学院以专科生录取。");  
        article1.setPicUrl("http://imgsrc.baidu.com/baike/pic/item/342ac65c10385343526c049f9013b07ecb8088e9.jpg");  
        article1.setUrl("http://baike.baidu.com/link?url=E7FsuTC-joUwKS9MrQDqyVOPOFq81PTtCcrkSTQsl54f_Jp3DWVYOaEJLr4FmUgbu0GgndzvvWB7QuIuN3uxDBBfQNuRBB3pJ8c5pURUKw3");  

        Article article2 = new Article();  
        article2.setTitle("楼上的老马叔");  
        article2.setDescription("1998年和好友张志东注册成立‘深圳市腾讯计算机系统有限公司’。2009年，腾讯入选《财富》“全球最受尊敬50家公司”。在2014年3000中国家族财富榜中马化腾以财富1007亿元荣登榜首，相比于2013年，财富增长了540亿元。2015年02月13日，入选“2014中国互联网年度人物”活动获奖名单。[1]  2015年3月2日，《福布斯》发布2015年福布斯中国富豪榜单，以161亿美元位列第六。[2]  4月，《财富》2015‘中国最具影响力的50位商界领袖’排行榜荣登第2位。[3] ");  
        article2.setPicUrl("http://szsb.sznews.com/res/1/1162/2015-08/10/A03/res01_attpic_brief.jpg");  
        article2.setUrl("http://baike.baidu.com/link?url=fP18fWnw6We6-qd_w50A9MbGtsnWsmKiLYlE8IxpzsTrVhnqEF5ISu0gm1_VQBKdlDCXxTErVYjoaj24w5Kcv_");  

        Article article3 = new Article();  
        article3.setTitle("帅哥小李");  
        article3.setDescription("1991年，李彦宏毕业于北京大学信息管理专业，随后前往美国布法罗纽约州立大学完成计算机科学硕士学位，先后担任道·琼斯公司高级顾问、《华尔街日报》网络版实时金融信息系统设计者，以及国际知名互联网企业——Infoseek公司资深工程师。李彦宏所持有的“超链分析”技术专利，是奠定整个现代搜索引擎发展趋势和方向的基础发明之一。");  
        article3.setPicUrl("http://y2.ifengimg.com/cmpp/2014/09/03/19/8ebe6c20-45d4-4767-89d5-b5ea15b19a31.jpg");  
        article3.setUrl("http://baike.baidu.com/view/2375.htm");  

        articleList.add(article1);  
        articleList.add(article2);  
        articleList.add(article3);  
        newsMessage.setArticleCount(articleList.size());  
        newsMessage.setArticles(articleList);
        //到此整个newsMessage对象已经整合完毕，开始转换为xml字符串
        respMsg = MessageUtil.newsMessageToXml(newsMessage); 
		return respMsg;

	}

}
