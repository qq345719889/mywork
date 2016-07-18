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

<title>My JSP 'success.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

</head>

<body>
	<div align="right">
		<a href="<%=basePath%>index.jsp">返回到主页</a>
	</div>
	<form method="post" name="form1">
		<table align="center" width="500px" height="300px">
			<thead>
				<tr>
					<td align="center" style="color:red"><h2>${titles}</h2></td>
				</tr>
				<tr align="right">
					<td>作者:${msg2.name}</td>
				</tr>
				<tr align="center">
					<td>${msg2.content}</td>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
	</form>

</body>
</html>
