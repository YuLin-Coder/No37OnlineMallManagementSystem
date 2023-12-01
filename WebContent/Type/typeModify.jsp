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
<form action="../TypeServlet" method="post">
<table>
	<tr>
		<th colspan="4">添加商品类型</th>
	</tr>
	<tr>
		<td class="objName">商品类型名称</td>
		<td><input type="text" name="typeName" value="<%=model.getTypeName() %>" /></td>
		<td class="objName" >商品类型编号</td>
		<td><%=model.getId() %></td>
	</tr>
	<tr>
		<td colspan="4" class="buttonBar">
			<input type="submit" value="修改" class="buttonStyle">
			<input type="reset" value="重置" class="buttonStyle">
			<input type="button" value="返回" class="buttonStyle" onclick="redictToQuery()" />
		</td>
	</tr>
</table>
<input type="hidden" name="id" value="<%=model.getId() %>" />
<input type="hidden" name="operate" value="modify" />
</form>
</body>
<script type="text/javascript">
function redictToQuery(){
	window.location.href="../TypeServlet?operate=query";
}
</script>
</html>