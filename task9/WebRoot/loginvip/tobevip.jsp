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

<title>My JSP 'tobevip.jsp' starting page</title>

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
	<form action="<%=path%>/new/tobevip.action" method="post">
		<center>
			<div>
				<h1>欢迎进入VIP升级界面，请仔细填写</h1>
			</div>
			<div>
				入会时间:<input type="date" name="joinTime" />
			</div>
			<div>
				姓名:<input type="text" name="name"  />
			</div>
			<div>
				年龄:<input type="number" name="age" />
			</div>
			<div>
				成分:<input type="text" name="profession" />
			</div>
			<input type="submit" name="tijiao" value="添加VIP">or <a
				href="<%=path%>/dologin/welcome.jsp">返回至系统主页面</a>
		</center>
	</form>
</body>
</html>
