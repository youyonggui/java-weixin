<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'random.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script language="javascript">
	
	function changeImg(id){
		//alert("");	int i = ;
		//传一个随机参数是为了避免缓存
		id.src="${pageContext.request.contextPath}/servlet/getvalicode?add="+Math.random();
	}
	
	</script>

  </head>
  
  <body>
    <div><img alt="看不清，换一张" src="${pageContext.request.contextPath}/servlet/getvalicode" onclick="changeImg(this)"></div>
  </body>
</html>
