package com.wxp.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yyg.wxServiceUtil.CoreService;
import com.yyg.wxServiceUtil.SignUtil;
import com.yyg.wxServiceUtil.getIp;
import com.yyg.wxServiceUtil.myfile;

//设为管理器
@Controller
//向WXVlidat.do请求
@RequestMapping("WXValidat.do")
public class WXUrlValidat {
	/**
	 * 微信服务器请求一响应的进出口
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	
	@RequestMapping(method = RequestMethod.GET)
	//截获向WxValidat.do请求get
	public void WXEntrance(HttpServletRequest request,HttpServletResponse response) throws IOException{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		// 微信加密签名
		String signature = request.getParameter("signature");
		// 时间戳
		String timestamp = request.getParameter("timestamp");
		// 随机数
		String nonce = request.getParameter("nonce");
		// 随机字符串
		String echostr = request.getParameter("echostr");

		PrintWriter out = response.getWriter();
		//得到访问者的IP地址
		String fromIp = getIp.getIpAddr(request);
		System.out.println(fromIp);
		myfile.writeLog(fromIp);
		if(SignUtil.checkSignature(signature, timestamp, nonce)){
			out.println(echostr);
			System.out.println("验证成功");
		}
		out.flush();
		out.close();
	}
	//处理来自微信的POST请求
	@RequestMapping(method = RequestMethod.POST)
	public void WXMessage(HttpServletRequest request,HttpServletResponse response) throws IOException{
		// 将请求、响应的编码均设置为UTF-8（防止中文乱码）
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		// 调用核心业务类接收消息、处理消息
		String respMessage = CoreService.processRequest(request);
		// 响应消息
		PrintWriter out = response.getWriter();
		out.print(respMessage);
				
			//	doGet(request,response);
		out.flush();
		out.close();
	}

}
