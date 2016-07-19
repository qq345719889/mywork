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

<title>My JSP 'vipbuy.jsp' starting page</title>

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
	<form action="<%=basePath%>new/vipbuy.action" method="post">
		<div>
			请选择您的VIP卡号:
			<s:select list="vip" theme="simple" listValue="vipId" listKey="vipId"
				name="vipId" id="vipSel"></s:select>
		</div>
		<div>
			<table>
				<thead>
					<tr>
						<th colspan="5">商品信息</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th>商品编号</th>
						<th>商品名称</th>
						<th>价格</th>
						<th>折扣</th>
						<th></th>
					</tr>
					<s:iterator id='id' value="goodsinfo" status="groupStatus">
						<tr>
							<td><s:property value="#id.commodityId" /> </td>
							<td><s:property value="#id.commodityName" /></td>
							<td><s:property value="#id.price" /></td>
							<td><s:property value="#id.agio" /></td>
							<td><a
								onclick="toBuy('<s:property value="#id.commodityId" />')"
								href="javascript:void(0);">购买</a></td>
						</tr>
					</s:iterator>
				</tbody>
			</table>

		</div>
	</form>
	<script type="text/javascript" src='../js/jquery-1.9.0.js'>	</script>
		<script type="text/javascript" src='../js/jquery-1.9.0.min.js'>	</script>
	<script type="text/javascript">
function toBuy(commodityId){
	var vipSel = $("#vipSel").val();
	window.location="<%=basePath%>new/vipbuy.action?vipId=" + vipSel
					+ "&commodityId=" + commodityId;
		}
	</script>
</body>
</html>
