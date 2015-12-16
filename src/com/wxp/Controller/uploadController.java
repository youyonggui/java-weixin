package com.wxp.Controller;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.com.sources.pojo.Images;
import org.com.sources.pojo.Loginuser;
import org.com.sources.pojo.News;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.yyg.wxServiceUtil.checkAdmin;
import com.yyg.wxServiceUtil.randomModel;

@Controller
public class uploadController {
	
	@RequestMapping("upload.do")
	public String findUpload(HttpServletRequest request,HttpServletResponse response) throws Exception{
		Loginuser user = getAdminCookie(request);
		if(null == user){
			return "primaryError";
		}
		try {
		 DiskFileItemFactory factory = new DiskFileItemFactory();
        // factory.setSizeThreshold(sizeThreshold); // 设置缓冲区大小，这里是4kb
        // factory.setRepository(tempPathFile);// 设置缓冲区目录
         ServletFileUpload upload = new ServletFileUpload(factory);
         upload.setHeaderEncoding("UTF-8");//解决文件乱码问题
       //  upload.setSizeMax(sizeMax);// 设置最大文件尺寸
        
		List<FileItem> items = upload.parseRequest(request);
		if(!items.isEmpty()){
			Iterator<FileItem> it = items.iterator();
			FileItem fi = null;
			String title = "";
			String content = "";
			String fileName = "";
			while(it.hasNext()){
				fi = it.next();
				if(!fi.isFormField() && fi.getName()!= "" && fi.getName() != null){
					Date date = new Date();
					String ip = getIpString(request.getRemoteAddr());
					String ext = fi.getName().substring(fi.getName().lastIndexOf(".")+1).toLowerCase();
					fileName = "upload/" + ip + date.getTime()+randomModel.randomString(4)+"."+ext;
					//fi.setFieldName(fileName);
					fileName = fileName.replace("\\","/");
					System.out.println(fileName);
					File file = new File(fileName);
					fi.write(file);
				}else{
					if("n_title".equals(fi.getFieldName())){
						title = fi.getString("utf-8");
					}else if("n_content".equals(fi.getFieldName())){
						content = fi.getString("utf-8");
					}
				}
			}
			Images img = new Images();
			img.setVals(fileName);
			
			Set<Images> imgs = new HashSet<Images>();
			imgs.add(img);
			
			News news = new News();
			news.setImageses(imgs);
			news.setAuthor(user.getName());
			news.setContent(content);
			news.setTitle(title);
			news.setStatus(0);
			Date date = new Date();
			news.setCTime(new Timestamp(date.getTime()));
			newsService.publicNews(news);
			
			return "news";
		//	System.out.println(null == "");
		//	System.out.println("".equals(null));
		//	System.out.println("".isEmpty());
		//	System.out.println(title+"---->"+content);
		}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return "error";
		/**
		SmartUpload su = new SmartUpload(); //实例化对象
		su.initialize(servletconfig, request, response);//初始化对象
		su.upload();//上传准备
		
		String title = su.getRequest().getParameter("title");
		System.out.println(title);
		String content = su.getRequest().getParameter("content");
		System.out.println(content);
		Date date = new Date();
		String ext = su.getFiles().getFile(0).getFileExt();	//	获取文件拓展名
		String fileName = getIpString(request.getRemoteAddr())+date.getTime()+randomModel.randomString(4)+"."+ext;
		su.getFiles().getFile(0).saveAs(servletconfig.getServletContext().getRealPath("/")+"upload"+java.io.File.separator+fileName);
		 //保存文件在upload文件夹下
		*/
	}
	
	private Loginuser getAdminCookie(HttpServletRequest request){
		Loginuser user = null;
		Cookie[] cookies = request.getCookies();
		String admin = "";
		String password = "";
		if(null != cookies && cookies.length != 0){
			for(Cookie co : cookies){
				if(co.getName().equals("myweixinAdmin")){
					admin = co.getValue();
				}else if(co.getName().equals("myweixinpwd")){
					password = co.getValue();
				}
			}
			user = checkAdmin.check(admin, password);
		}
		return user;
		
	}
	
	private String getIpString(String ip){
		StringBuffer sb = new StringBuffer();
		if(!ip.isEmpty()){
			String[] str = ip.split("\\.");
			for(int i=0;i<str.length;i++){
				sb.append(addZero(str[i],3));
			}
		}
		
		return sb.toString();
	}
	
	private String addZero(String str,int digits){
		StringBuffer sb = new StringBuffer();
		sb.append(str);
		while(sb.length()<digits){
			sb.insert(0, 0);
		}
		return sb.toString();
	}

}
