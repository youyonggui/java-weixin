package com.yyg.wxServiceUtil;


import net.sf.json.JSONObject;

public class readMenu {
	/*
	 * 查询菜单
	 * 用GET请求
	 * */
	public static String geturl = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";
	
	public static String deleteurl = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";
	
	public String readMymenu() {

		//获取accesstoken
		AccessToken at = WeixinUtil.getAccessToken(AccessToken.appId, AccessToken.appSecret);
		String url = geturl.replace("ACCESS_TOKEN", at.getToken());
		
		JSONObject jb = WeixinUtil.httpRequest(url, "GET", null);
		
		return jb.toString();
	}
	public boolean deleteMymenu() {
		
		//获取accesstoken
		AccessToken at = WeixinUtil.getAccessToken(AccessToken.appId, AccessToken.appSecret);
		String url = deleteurl.replace("ACCESS_TOKEN", at.getToken());
		
		JSONObject jb = WeixinUtil.httpRequest(url, "GET", null);
		
		return (jb.getInt("errcode") == 0 && jb.get("errmsg") == "ok") ? true : false;
	}
}
