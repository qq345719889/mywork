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
		<div>
			<table>
				<thead>
					<tr>
						<th colspan="6">vip购物信息</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th>vip编号</th>
						<th>vip姓名</th>
						<th>商品名</th>
						<th>价格</th>
						<th>折后价</th>
					</tr>
					<s:iterator id='id' value="consumeinfo" status="groupStatus">
						<tr>
							<td><s:property value="vipId" /></td>
							<td><s:property value="#id.name" /></td>
							<td><s:property value="#id.commodityName" /></td>
							<td><s:property value="#id.price" /></td>
							<td><s:property value="#id.practicePrice" /></td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
		</div><a href="<%=path%>/loginvip/vipindex.jsp">返回</a>
	</center>
</body>
</html>
