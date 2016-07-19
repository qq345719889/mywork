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

<title>My JSP 'findvipinfo.jsp' starting page</title>

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
		<form action="<%=basePath%>new/vipinfoquery.action" method="post">
			<div>
				请选择您要查询的VIP卡号:
				<s:select list="vip" theme="simple" listValue="vipId"
					listKey="vipId" name="vipId" id="vipSel"></s:select>
			</div>
			<div>
				<input type="submit" name="tijiao" value="提交" />
			</div>
		</form>
	</center>
</body>
</html>
