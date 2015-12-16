package com.yyg.struts;

public class MenuURL {
	
	private static String createMwnuURL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	
	private static String deleteMenuURL = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";
	
	private static String getMenuURL = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";
	
	private static String getMenuSettingURL = "https://api.weixin.qq.com/cgi-bin/get_current_selfmenu_info?access_token=ACCESS_TOKEN";

	public static String getCreateMwnuURL(String access_token) {
		MenuURL.createMwnuURL = createMwnuURL.replace("ACCESS_TOKEN", access_token);
		return createMwnuURL;
	}

	public static String getDeleteMenuURL(String access_token) {
		MenuURL.deleteMenuURL = deleteMenuURL.replace("ACCESS_TOKEN", access_token);
		return deleteMenuURL;
	}

	public static String getGetMenuURL(String access_token) {
		MenuURL.getMenuURL = getMenuURL.replace("ACCESS_TOKEN", access_token);
		return getMenuURL;
	}

	public static String getGetMenuSettingURL(String access_token) {
		MenuURL.getMenuSettingURL = getMenuSettingURL.replace("ACCESS_TOKEN", access_token);
		return getMenuSettingURL;
	}
	
}
