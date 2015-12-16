package com.yyg.wxServiceUtil;

import net.sf.json.JSONObject;

public class MenuManager {

	/**
	 * @author yyg
	 * @date 2015
	 */
	//private static String URL_URL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=state#wechat_redirect";
	private static String URL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx15aa3286d2b75461&redirect_uri="+URLCode.urlEncodeUTF8("http://111。73.196.143/WX_YYG_PRO/servlet/WeinxinOauth2")+"&response_type=code&scope=snsapi_base&state=TARGET#wechat_redirect";

	public static void main(String[] args) {
		//String appId = "wx15aa3286d2b75461";
		
		//String appSecret = "73f89efcfdea64e919638a0316c524f0";
		
		AccessToken at = WeixinUtil.getAccessToken(AccessToken.appId, AccessToken.appSecret);

		if (null != at) {
			//将对象以json对象的形式读取并且转换为字符串
			String jsonMenu = JSONObject.fromObject(getMenu()).toString();
			System.out.println(jsonMenu);
			System.out.println(at.getToken());
			WeixinUtil.createMenu(getMenu(), at.getToken());
			
		}
	}
	
	private static Menu getMenu() {
		CommonButton btn11 = new CommonButton();
		btn11.setName("基地简介");
		btn11.setType("click");
		btn11.setKey("click_11");

		String t_url = URL.replace("TARGET", "TEAMINFO");
		viewButton btn12 = new viewButton();
		btn12.setName("成员信息");
		btn12.setType("view");
		btn12.setUrl(t_url);
		
		String op_url = URL.replace("TARGET", "OPINION");
		viewButton btn13 = new viewButton();
		btn13.setName("反馈意见");
		btn13.setType("view");
		btn13.setUrl(op_url);
		
		String wj_url = URL.replace("TARGET", "RESEARCH");
		viewButton btn31 = new viewButton();
		btn31.setName("问卷调查");
		btn31.setType("view");
		//"http://www.sojump.com/jq/5776748.aspx"
		btn31.setUrl(wj_url);
		
		String action = URL.replace("TARGET", "ACTION");
		viewButton btn32 = new viewButton();
		btn32.setName("活动报名");
		btn32.setType("view");
		//http://www.sojump.com/jq/5816131.aspx
		btn32.setUrl(action);

		ComplexButton mainBtn1 = new ComplexButton();
		mainBtn1.setName("介绍");
		mainBtn1.setSub_button(new Button[] { btn11, btn12, btn13});

		String n_url = URL.replace("TARGET", "NEWS");
		viewButton btn2 = new viewButton();
		btn2.setName("新闻");
		btn2.setType("view");
		//"http://111.76.197.210/myweixin/client/tonews.html"
		btn2.setUrl(n_url);

		ComplexButton mainBtn3 = new ComplexButton();
		mainBtn3.setName("活动");
		mainBtn3.setSub_button(new Button[] { btn31, btn32});

		Menu menu = new Menu();
		menu.setButton(new Button[] { mainBtn1, btn2, mainBtn3 });

		return menu;
	}

}
