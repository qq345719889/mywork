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

<title>My JSP 'vipbuy.jsp' starting page</title>

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
	<center>
		<div>
			VIP卡号为
			<s:property value="vipId" />
			,用户 
			<s:property value="name" />
			登记商品成功！
		</div>
		<div>
			<a href="<%=path%>/loginvip/vipindex.jsp">返回</a>
		</div>
		<div>
			<a href="<%=path%>/new/tovipbuy.action">继续登记</a>
		</div>
	</center>
</body>
</html>
