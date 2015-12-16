package com.wxp.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yyg.struts.respMsg;
import com.yyg.wxServiceUtil.RandomCodeUtil;

import net.sf.json.JSONObject;
//
@Controller
public class validCodeController {
	
	@RequestMapping("getCode.do")
	public void getCode(HttpServletRequest request,HttpServletResponse response) throws IOException{
	
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		//System.out.println("ok");
		String id = request.getParameter("id");
		if(id != null && id != "")
			RandomCodeUtil.createRandomCode(request, response);
		else{
			PrintWriter out = response.getWriter();
			String code = request.getParameter("code");
			respMsg respM = new respMsg();
			
			if(RandomCodeUtil.checkRandomCode(request, code)){
				respM.setMsg("success");
				respM.setSuccess(true);
			}else{
				respM.setMsg("failed");
				respM.setSuccess(false);
			}
			out.println(JSONObject.fromObject(respM).toString());
			
			out.flush();
			out.close();
		}
	}
}
