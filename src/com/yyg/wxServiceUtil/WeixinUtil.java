package com.yyg.wxServiceUtil;

import java.io.*;
import java.net.ConnectException;
import java.net.URL;
import java.lang.StringBuffer;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;


import net.sf.json.JSONException;
import net.sf.json.JSONObject;

public class WeixinUtil {


	public static JSONObject httpRequest(String requestUrl, String requestMethod, String outputStr) {
		JSONObject jsonObject = null;
		StringBuffer buffer = new StringBuffer();
		try {
			// http权限证书凭据
			TrustManager[] tm = { new MyX509TrustManager() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());
			// 
			SSLSocketFactory ssf = sslContext.getSocketFactory();

			URL url = new URL(requestUrl);
			HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();
			httpUrlConn.setSSLSocketFactory(ssf);

			httpUrlConn.setDoOutput(true);
			httpUrlConn.setDoInput(true);
			httpUrlConn.setUseCaches(false);
			// 
			httpUrlConn.setRequestMethod(requestMethod);

			if ("GET".equalsIgnoreCase(requestMethod))
				httpUrlConn.connect();

			// 
			if (null != outputStr) {
				java.io.OutputStream outputStream = httpUrlConn.getOutputStream();
				//
				outputStream.write(outputStr.getBytes("UTF-8"));
				outputStream.close();
			}
			//
			// 
			java.io.InputStream inputStream = httpUrlConn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			bufferedReader.close();
			inputStreamReader.close();
			// 
			inputStream.close();
			inputStream = null;
			httpUrlConn.disconnect();
			jsonObject = JSONObject.fromObject(buffer.toString());
		} catch (ConnectException ce) {

		} catch (Exception e) {
		}
		return jsonObject;
	}
	
	// 
	public final static String access_token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

	
	public static AccessToken getAccessToken(String appid, String appsecret) {
		AccessToken accessToken = null;

		String requestUrl = access_token_url.replace("APPID", appid).replace("APPSECRET", appsecret);
		JSONObject jsonObject = httpRequest(requestUrl, "GET", null);
		// 
		if (null != jsonObject) {
			try {
				accessToken = new AccessToken();
				accessToken.setToken(jsonObject.getString("access_token"));
				accessToken.setExpiresIn(jsonObject.getInt("expires_in"));
				
				
			} catch (JSONException e) {
				accessToken = null;
				
			}
		}
		
		return accessToken;
	}
	

	public static String menu_create_url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";

	/**
	 * 创建菜单
	 * 首先必须得到accesston
	 * 在得到menu
	 * 传入参数
	 * 
	 */
	public static int createMenu(Menu menu, String accessToken) {
		int result = 0;
		//传入指定的参数即可创建成功
		// 拼接URL
		String url = menu_create_url.replace("ACCESS_TOKEN", accessToken);
		// 将菜单转换成字符串
		String jsonMenu = JSONObject.fromObject(menu).toString();
		// 开始发起请求
		JSONObject jsonObject = httpRequest(url, "POST", jsonMenu);
		
		System.out.println(jsonObject.get("errmsg"));
		
		if (null != jsonObject) {
			if (0 != jsonObject.getInt("errcode")) {
				result = jsonObject.getInt("errcode");
			}
		}

		return result;
	}
}
