
<%@ page language="java" import="java.awt.event.*" pageEncoding="utf-8"%>
<%@ page language="java" import="javax.swing.*" %>
<%@ page language="java" import="java.applet.Applet" %>
<%@ page language="java" import="java.util.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'create.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    This is my JSP page. <br>
    <%
    @SuppressWarnings("serial")
    JButton b;
	JFrame f;
	int n = 0;
    f = new JFrame("计数");
	f.setVisible(true);
	b = new JButton("点我有次数哦");
	f.getContentPane().add(b);
	b.setVisible(true);
	//b.addActionListener(this);
	f.pack();%>
  </body>
</html>
