<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'vipindex.jsp' starting page</title>

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
	<div>
		<a href="<%=path%>/new/tovipbuy.action">VIP购物登记模块</a>
	</div>
	<div>
		<a href="<%=path%>/new/vipidquery.action">VIP信息查询</a>
	</div>
	<div>
		<a href="<%=path%>/loginvip/tobevip.jsp">VIP信息管理</a>
	</div>
</body>
</html>
