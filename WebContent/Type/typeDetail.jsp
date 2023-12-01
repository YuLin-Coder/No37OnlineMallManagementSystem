<%@page import="vo.Type"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品类型详情</title>
<link rel="stylesheet" type="text/css" href="../CSS/detailTable.css">
</head>
<%
	Type model=(Type)session.getAttribute("SelectedTypeInfo");
%>
<body>
<table>
	<tr>
		<th colspan="4">添加商品类型</th>
	</tr>
	<tr>
		<td class="objName">商品类型名称</td>
		<td><%=model.getTypeName() %></td>
		<td class="objName" >商品类型编号</td>
		<td><%=model.getId() %></td>
	</tr>
	<tr>
		<td colspan="4" class="buttonBar">
			<input type="button" value="返回" class="buttonStyle" onclick="redictToQuery()">
		</td>
	</tr>
</table>
</body>
<script type="text/javascript">
function redictToQuery(){
	window.location.href="../TypeServlet?operate=query";
}
</script>
</html>