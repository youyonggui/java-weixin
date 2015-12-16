package com.wxp.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yyg.struts.respMsg;
import com.yyg.wxServiceUtil.getIp;

import net.sf.json.JSONObject;
//控制器
@Controller
public class clientController {
	
	@RequestMapping("clientgGet.do")
	public void ClientControl(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		//客户端接口
		respMsg respmsg = new respMsg();
		//
		
		String from = request.getParameter("from");
		//建议
		if(from.equals("news")){
			//新闻
			String posi = request.getParameter("position");
			int position = Integer.parseInt(posi);
			teamInfoUtil.moreNews(position, respmsg);
			System.out.println(getIp.getIpAddr(request)+"请求更多数据。。");
			
		}else if(from.equals("opinion")){
			
			opinionServiceSql.opinSave(respmsg, request);
			
			//response.sendRedirect("../client/backOpinions.jsp");
			//System.out.println("成功！");
			//信息
		}else if(from.equals("teaminfo")){
			String action = request.getParameter("action");
			if(action.equals("more")){
				String pt = request.getParameter("position");
				int position = Integer.parseInt(pt);
				teamInfoUtil.moreOptionClient(position, respmsg);
				//teamInfoUtil.moreOptionClient(position,respmsg);
				System.out.println(getIp.getIpAddr(request)+"请求更多数据。。");
			}else{
				respmsg.setMsg("传入的参数错误！");
				System.out.println("传入的参数错误！");
			}
			
		}else{
			respmsg.setMsg("传入的参数错误！");
			System.out.println("传入的参数错误！");
		}
		
		out.println(JSONObject.fromObject(respmsg).toString());
		out.flush();
		out.close();
	}

}
