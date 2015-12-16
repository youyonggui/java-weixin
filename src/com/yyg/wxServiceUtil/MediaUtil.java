package com.yyg.wxServiceUtil;

public class MediaUtil {
	
	/**
	 * 根据内容类型判断文件扩展名
	 */
	public static String getFileExt(String contentType){
		String fileExt = "";
		if("image/jpeg".equals(contentType)){
			fileExt = ".jpg";
		}
		else if("audio/mpeg".equals(contentType)){
			fileExt = ".mp3";
		}
		else if("audior".equals(contentType)){
			fileExt = ".amr";
		}
		else if("video/mp4".equals(contentType)){
			fileExt = ".mp4";
		}
		else if("video/mpeg4".equals(contentType)){
			fileExt = ".mp4";
		}
		return fileExt;
	}


}
