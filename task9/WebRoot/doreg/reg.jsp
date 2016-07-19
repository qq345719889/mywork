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

<title>用户注册页</title>
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
	<div align="center">
		<form action="<%=path%>/new/reg.action" method="post"
			onsubmit="return check()">
			<table style="border: solid;1px;text-align: center">
				<thead>
					<tr>
						<td colspan="2">用户注册页</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>用户名：</td>
						<td><input type="text" name="username" style="width: 141px; " /></td>
					</tr>
					<tr>
						<td>密码：</td>
						<td><input type="password" name="password"
							style="width: 141px; " /></td>
					</tr>
					<tr>
						<td>确认密码：</td>
						<td><input type="password" name="password1"
							style="width: 141px; " /></td>
					</tr>
					<tr>
						<td><input type="submit" name="tijiao" value="提交" /></td>
						<td><input type="reset" name="reset" value="重置" /></td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
	<div align="center">
		<a href=../dologin/login.jsp>返回登陆页面</a>
	</div>
</body>
<script type="text/javascript">
	function check() {
		if (document.getElementsByName("username").item(0).value == "") {
			alert("用户名为空，请重新输入");
			return false;
		}
		if (document.getElementsByName("password").item(0).value == "") {
			alert("首次密码为空，请重新输入");
			return false;
		}
		if (document.getElementsByName("password1").item(0).value == "") {
			alert("再次输入密码为空，请重新确认密码");
			return false;
		}
		if (document.getElementsByName("password1").item(0).value != document
				.getElementsByName("password").item(0).value) {
			alert("两次密码输入不一致，请重新确认密码");
			return false;
		}
		return true;
	}
</script>
</html>
