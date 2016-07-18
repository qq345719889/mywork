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

<title>唐诗主页</title>

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
	<div align="right">
		<form action="new/findname.do" method="post">
			按作者搜索作品：<input type="text" name="name" /> <input type="submit"
				value="查询" />
		</form>
	</div>
	<div align="right">
		<form action="new/findwork.do" method="post">
			按作品搜索唐诗全文：<input type="text" name="titles" /> <input type="submit"
				value="查询" />
		</form>
	</div>
	<div align="right">
		<form action="new/part.do" method="post">
			按名句搜索作者，题目和全文：<input type="text" name="part" /> <input type="submit"
				value="查询" />
		</form>
	</div>
	<div align="center" style="color:orange">
		<h1>欢迎来到唐诗世界！</h1>
	</div>
	<div style="margin-left: 260px;height: 300px;">
		<img alt="杜甫" src="<%=basePath%>pic/dufu.jpg" width="200px"
			height="200px">
		&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<img
			alt="李白" src="<%=basePath%>pic/libai.jpg" width="200px"
			height="200px">
	</div>
</body>
</html>
