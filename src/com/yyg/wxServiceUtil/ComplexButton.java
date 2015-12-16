package com.yyg.wxServiceUtil;

public class ComplexButton extends Button{
	private Button[] sub_button;
	//二级菜单
	public Button[] getSub_button() {//得到
		return sub_button;
	}
	//
	public void setSub_button(Button[] sub_button) {//设置
		this.sub_button = sub_button;
	}
}
