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
<title>My JSP 'addgoods.jsp' starting page</title>

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
	<form action="<%=path%>/new/addgoods.action" method="post"
		onsubmit="return check()">
		<div>
			<a href="<%=path%>/dologin/welcome.jsp">返回系统主页面</a>
		</div>
		<div>商品信息录入</div>
		<div>
			商品名称:<input type="text" name="commodityName" />
		</div>
		<div>
			商品价格:<input type="number" name="price" />
		</div>
		<div>
			商品折扣:<input type="number" name="agio" />
		</div>
		<div>
			<input type="submit" name="tijiao" value="提交" />
		</div>
	</form>
	<script type="text/javascript">
		function check() {
			if (document.getElementsByName("commodityName").item(0).value == "") {
				alert("商品名称为空，请重新输入");
				return false;
			}
			if (document.getElementsByName("price").item(0).value == "") {
				alert("商品价格为空，请重新输入");
				return false;
			}
			if (document.getElementsByName("agio").item(0).value == "") {
				alert("折扣为空，请重新输入");
				return false;
			}
			return true;
		}
	</script>
</body>
</html>
