package com.yyg.wxServiceUtil;

public class AccessToken {
	//
		public static String appId="wx15aa3286d2b75461";
				
		public static String appSecret = "73f89efcfdea64e919638a0316c524f0";
			
		private String token;
		// 
		private int expiresIn;

		public String getToken() {
			return token;
		}

		public void setToken(String token) {
			this.token = token;
		}

		public int getExpiresIn() {
			return expiresIn;
		}

		public void setExpiresIn(int expiresIn) {
			this.expiresIn = expiresIn;
		}
}
