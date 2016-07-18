<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<script type="text/javascript">
	function next() {
		var nwSel = $("#nwSel").val();
		nwSel = parseInt(nwSel) + 1;
		window.location.href = "turn.do?nwPage=" + nwSel;
	}
	function previous() {
		var nwSel = $("#nwSel").val();
		nwSel = parseInt(nwSel) - 1;
		window.location.href = "turn.do?nwPage=" + nwSel;
	}
</script>
</head>
<body>
	<div>
		<h1>作者： ${sessionScope.name}</h1>
	</div>
	<div align="right">
		<a href="<%=basePath%>index.jsp">返回到主页</a>
	</div>

	<form method="post" name="form1">
		<input type="hidden" id="nwSel" value="${nwPage }" />
		<table align="center" width="500px" height="300px">
			<thead>
				<tr>
					<td colspan="3" align="center" style="color:red">诗名(共查询到
						${sessionScope.count}条)</td>
					<td></td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${msg1}" var="p" varStatus="status">
					<tr
						<c:if test="${status.count % 2==0}">bgcolor="black" style="color:white"</c:if>>
						<td colspan="3" align="center">${p}</td>
					</tr>
				</c:forEach>
				<tr>
					<c:if test="${isMin}">
						<td width="150px"></td>
						<td width="150px"><input type="button" name="nextpage"
							value="下一页" onClick="next()"></td>
					</c:if>
					<c:if test="${isMax}">
						<td width="150px"><input type="button" name="prepage"
							value="上一页" onClick="previous()"></td>
						<td width="150px"></td>
					</c:if>
					<c:if test="${isP}">
						<td width="150px"><input type="button" name="prepage"
							value="上一页" onClick="previous()"></td>
						<td width="150px"><input type="button" name="nextpage"
							value="下一页" onClick="next()"></td>
					</c:if>
					<td width="200px" style="color: blue;" align="right">第${nwPage}页
						第${minCt}至${maxCt}条记录</td>
				</tr>


			</tbody>
		</table>
	</form>
	<script type="text/javascript" src='<%=basePath%>js/jquery-1.9.0.js'>
		
	</script>
	<script type="text/javascript"
		src='<%=basePath%>/js/jquery-1.9.0.min.js'>
		
	</script>
</body>
</html>
