package com.wxp.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yyg.struts.respMsg;
import com.yyg.wxServiceUtil.checkPrimary;

@Controller
public class coreController {
	
	//返回代码：{"success":"true/false","msg":"错误提示"}
		//成功代码：{"success":true,"msg":"success"}
		private static final String FROM_NEWS = "news";
		private static final String FROM_OPINION = "opinion";
		private static final String FROM_INTRDUCTION = "intrduction";
		private static final String FROM_INFORMATION = "information";
		private static final String INFORMATION_COM_ADD = "add";
		private static final String INFORMATION_COM_UPDATE = "update";
		private static final String INFORMATION_COM_SELECT = "select";
		private static final String INFORMATION_COM_DELETE = "delete";
		private static final String FROM_ACTIVITY = "activity";
		private static final String NEWS_COM_ADD = "add";
		private static final String NEWS_COM_MODIFY = "modify";
		private static final String NEWS_COM_SELECT = "select";
		private static final String NEWS_COM_DELETE = "delete";
		private static final String NEWS_COM_SELECTCONTENT = "selectcontent";
		private static final String INTRDUCTION_COM_ADD = "add";
		private static final String INTRDUCTION_COM_UPDATE = "update";
		private static final String INTRDUCTION_COM_DELETE = "delete";
		private static final String INTRDUCTION_COM_SELECT = "select";
		private static final String OPINION_COM_SELECT = "select";
		
	@RequestMapping("doit.do")
	private void doitPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		response.setHeader("Connection", "keep-alive");
		
		//List<String> list = new ArrayList<String>();
		respMsg respM = new respMsg();
		//检查通行证
		int primary = checkPrimary.checkPrim(request);
		if(-1 == primary){
			respM.setMsg("您没有相关后台权限!");
			respM.setSuccess(false);
			out.println(JSONObject.fromObject(respM).toString());
			return;
			//没有权限就退出操作
		}
		
		String doFrom = request.getParameter("doFrom");
		String doCom = request.getParameter("doCom");
		
		System.out.println(doFrom+"---->"+doCom);
		
		if(doFrom.equals(FROM_NEWS)){
			//新闻处理
			if(doCom.equals(NEWS_COM_SELECT) && primary >=0){
				//查看新闻
				newsService.selectNews(respM, request);
				//直接返回数据
				out.println(respM.getMsg());
				System.out.println(respM.getMsg());
			}else if(doCom.equals(NEWS_COM_SELECTCONTENT) && primary >=0){
				//查看新闻内容
				String idstr = request.getParameter("id");
				int id = Integer.parseInt(idstr);
				newsService.selectContent(respM, id);
				//直接返回数据
				
				out.println(respM.getMsg());
				
			}else if(doCom.equals(NEWS_COM_ADD) && primary >=1){//添加新闻处理
				/*
				 * n_title,
				 * n_content
				 * n_pictrue
				 * n_author
				 * */
				newsService.publicNews(respM, request);
				out.println(JSONObject.fromObject(respM).toString());
			}else if(doCom.equals(NEWS_COM_DELETE) && primary >=2){
				/*
				 * @param id 
				 * */ 
				newsService.deleteNews(respM, request);
				out.println(JSONObject.fromObject(respM).toString());
			}else if(doCom.equals(NEWS_COM_MODIFY) && primary >=1){
				
			}else{
				respM.setSuccess(false);
				respM.setMsg("参数错误！");
				out.println(JSONObject.fromObject(respM).toString());
				//System.out.println(JSONObject.fromObject(respM).toString());
			}
			
		}else if(doFrom.equals(FROM_INFORMATION)){
			//成员信息处理
			if(doCom.equals(INFORMATION_COM_ADD) || doCom.equals(INFORMATION_COM_UPDATE) && primary >=1){
				//刷新增添
				teamSqlInfo.updateTeamInfo(respM,request);
				out.println(JSONObject.fromObject(respM).toString());
			}else if(doCom.equals(INFORMATION_COM_DELETE) && primary >=2){
				//删除
				teamSqlInfo.teamInfoDel(respM, request);
				out.println(JSONObject.fromObject(respM).toString());
			}else if(doCom.equals(INFORMATION_COM_SELECT) && primary >=0){
				//遍历
				teamSqlInfo.teamInfoSelect(respM,request);
				//直接打印返回json字符串
				out.println(respM.getMsg());
				//out.println(JSONObject.fromObject(respM).toString());
			}else{
				respM.setSuccess(false);
				respM.setMsg("参数错误。。。");
				//参数出错
				out.println(JSONObject.fromObject(respM).toString());
			}
			
		}else if(doFrom.equals(FROM_ACTIVITY)){
			//活动处理
			
		}else if(doFrom.equals(FROM_INTRDUCTION)){
			//基地介绍处理
			if(doCom.equals(INTRDUCTION_COM_UPDATE) && primary >=1){
				//更新基地介绍
				JDIntrdu.updateJDInfo(respM, request);
				out.println(JSONObject.fromObject(respM).toString());
			}else if(doCom.equals(INTRDUCTION_COM_SELECT) && primary >=0){
				//查找基地介绍
				JDIntrdu.selectJDInfo(respM);
				//System.out.println(respM.getMsg());
				out.println(JSONObject.fromObject(respM).toString());
			}
			
		}else if(doFrom.equals(FROM_OPINION)){
			//建议处理
			if(doCom.equals(OPINION_COM_SELECT) && primary >=0){
				//查询
				opinionServiceSql.opinSelect(respM, request);
				//直接返回数据
				out.println(respM.getMsg());
			}else{
				
			}
		}else{
			//参数错误处理
			respM.setMsg("参数错误");
			respM.setSuccess(false);
			out.println(JSONObject.fromObject(respM).toString());
		}
		
		out.flush();
		out.close();

	}

}
