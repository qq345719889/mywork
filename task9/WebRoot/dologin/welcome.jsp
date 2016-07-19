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

<title>登陆成功</title>
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
	<div align="center">登陆成功！</div>
	<div align="center">
		欢迎
		<s:property value="#session.username" />
		来到商场VIP消费情况查询系统
	</div>
	<div align="center">
		<a href="<%=path%>/dologin/login.jsp">返回登陆页面</a>
	</div>
	<div>
		<a href="<%=path%>/goodsinfo/goodsindex.jsp">商品信息模块</a>
	</div>
	<div>
		<a href="<%=path%>/loginvip/vipindex.jsp">VIP信息模块</a>
	</div>
	<div>
		<a href="<%=path%>/new/queryuser.action">系统维护模块</a>
	</div>
	<div>
		<a href="<%=path%>/dologin/help.jsp">帮助模块</a>
	</div>
</body>
</html>
