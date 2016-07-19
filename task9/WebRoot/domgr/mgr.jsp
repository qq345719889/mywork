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

<title>超级管理员</title>
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
			<table style="border: solid;1px">
				<thead>
					<tr>
						<th colspan="3">系统维护</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th>用户名</th>
						<th colspan="2">操作</th>
					</tr>
					<s:iterator id='id' value="userinfo" status="groupStatus">
						<tr>
							<td><s:property value="id" /></td>
							<s:if test="#session.username.equals(#id)">
								<td></td>
								<td><input name="button2" type="button" value="授权"
									onClick="window.location.href='tobemgr.action?usernamesg=<s:property value='id'/>'"></td>
							</s:if>
							<s:else>
								<td><input name="button2" type="button" value="删除"
									onClick="window.location.href='deleteuser.action?usernamesg=<s:property value='id'/>'"></td>
								<td><input name="button2" type="button" value="授权"
									onClick="window.location.href='tobemgr.action?usernamesg=<s:property value='id'/>'"></td>
							</s:else>
						</tr>
					</s:iterator>
				</tbody>
			</table>
			<s:property value="msg" />
		</div>
		<a href="<%=path%>/dologin/welcome.jsp">返回主页面</a>
	</center>
</body>
</html>
