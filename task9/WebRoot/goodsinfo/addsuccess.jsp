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

<title>My JSP 'addsuccess.jsp' starting page</title>

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
		您已将商品
		<s:property value="commodityName" />
		添加成功
	</div>
	<div>
		价格为:
		<s:property value="price" />
	</div>
	<div>
		折扣为:
		<s:property value="agio" />
	</div>
	<div>
		<a href="<%=path%>/goodsinfo/addgoods.jsp">继续添加</a>
	</div>
	<div>
		<a href="<%=path%>/dologin/welcome.jsp">返回到系统主界面</a>
	</div>
</body>
</html>
