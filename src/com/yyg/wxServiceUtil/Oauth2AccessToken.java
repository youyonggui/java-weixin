package com.yyg.wxServiceUtil;

import com.yyg.struts.oauth2Token;

import net.sf.json.JSONObject;

public class Oauth2AccessToken {
	
	/*
	 * 获取token时会返回openid，用于获取用户的信息
	 * */

	public static oauth2Token getOa_token(String code) {
		String oa_token_url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
		oauth2Token ot = new oauth2Token();
		
		String url = oa_token_url.replace("APPID", AccessToken.appId);
		
		url = url.replace("SECRET", AccessToken.appSecret);
		
		url = url.replace("CODE", code);
		//System.out.println("url="+url);
		
		JSONObject obj = WeixinUtil.httpRequest(url, "GET", null);
		
		//System.out.println("obj="+JSONObject.fromObject(obj).toString());
		
		if(obj != null){
			
			try {
				ot.setAccessToken(obj.getString("access_token"));
				ot.setExpires_In(obj.getInt("expires_in"));
				ot.setOpenID(obj.getString("openid"));
				ot.setRefreshToken(obj.getString("refresh_token"));
				ot.setScope(obj.getString("scope"));
				
			} catch (Exception e) {
				// TODO: handle exception
				
				e.printStackTrace();
			}
		}
		
		return ot;
	}
	//如果cookie中还存在可用的token，就刷新。。。
	public static oauth2Token refreshToken(String token) {
		oauth2Token ot = new oauth2Token();
		
		String url = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=APPID&grant_type=refresh_token&refresh_token=REFRESH_TOKEN";
		//拼接地址
		url = url.replace("APPID", AccessToken.appId);
		
		url = url.replace("REFRESH_TOKEN", token);
		
		JSONObject obj = WeixinUtil.httpRequest(url, "GET", null);
		
		if(null != obj){
			
			try {
				ot.setAccessToken(obj.getString("access_token"));
				ot.setExpires_In(obj.getInt("expirres_in"));
				ot.setOpenID(obj.getString("openid"));
				ot.setRefreshToken(obj.getString("refresh_token"));
				ot.setScope(obj.getString("scope"));
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		return ot;
		
	}
}
