<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP 'info.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

</head>

<body>
	<div align="center">恭喜您注册成功！</div>
	<div align="center">
		您的账号是 ：
		<s:property value="username" />
	</div>
	<div align="center">
		您的密码是：
		<s:property value="password" />
	</div>
	<div align="center">请妥善保管！</div>
	<div align="center">
		<a href=../dologin/login.jsp>返回登陆页面</a>
	</div>
</body>
</html>
