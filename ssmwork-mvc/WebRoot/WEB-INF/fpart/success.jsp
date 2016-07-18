<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'success.jsp' starting page</title>

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
		<a href="<%=basePath%>index.jsp">返回到主页</a>
	</div>
	<table style="border-style: solid;" align="center" width="500px"
		height="300px" bordercolor="#000000">
		<c:forEach items="${msg3}" var="pt" varStatus="status">
			<tr
				<c:if test="${status.count % 2==0}">bgcolor="black" style="color:white"</c:if>
				align="center">
				<td align="center" width="150">${pt.name}</td>
				<td align="center" width="150">${pt.title}</td>
				<td align="center" width="200">${pt.content}</td>
			</tr>
		</c:forEach>
	</table>
	共查询到 ${count} 条记录

</body>
</html>
