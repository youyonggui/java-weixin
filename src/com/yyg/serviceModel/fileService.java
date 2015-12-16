package com.yyg.serviceModel;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;



public class fileService {
	
	public void saveFile(HttpServletRequest request) throws IOException{
		ServletInputStream in = request.getInputStream();
		File file = new File("/admin/images/23f34tw4t3f34.jsp");
	}

}
