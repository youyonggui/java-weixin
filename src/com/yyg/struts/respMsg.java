package com.yyg.struts;

public class respMsg {
	
	private static String msg;
	
	private static boolean success;
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		respMsg.msg = msg;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		respMsg.success = success;
	}

}
