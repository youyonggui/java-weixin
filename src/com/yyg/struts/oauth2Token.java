package com.yyg.struts;

public class oauth2Token {
	
	private String accessToken;
	
	private String refreshToken;
	
	private int expires_In;
	
	private String openID;
	
	private String scope;

	public int getExpires_In() {
		return expires_In;
	}

	public void setExpires_In(int expires_In) {
		this.expires_In = expires_In;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	

	public String getOpenID() {
		return openID;
	}

	public void setOpenID(String openID) {
		this.openID = openID;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}
	
	

}
