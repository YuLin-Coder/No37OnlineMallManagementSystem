<%@page import="java.util.Iterator"%>
<%@page import="vo.Type"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品类型查询</title>
<link rel="stylesheet" type="text/css" href="../CSS/queryTable.css">
</head>
<%
	@SuppressWarnings("unchecked")
	List<Type> li=(List<Type>)session.getAttribute("TypeList");
	Iterator<Type> it=li.iterator();
%>
<body>
<table>
	<tr class="title">
			<td>商品类型编号</td>
			<td>商品类型名称</td>
			<td class="col_operate">操作</td>
    </tr>
    <%
		while(it.hasNext()){
			Type model=it.next();
	%>
	<tr class="list">
		<td><%=model.getId() %></td>
		<td><%=model.getTypeName() %></td>
		<td>
			<a href="../TypeServlet?operate=getModel&page=detail&id=<%=model.getId() %>">查看详细</a>
			<a href="../TypeServlet?operate=getModel&page=modify&id=<%=model.getId() %>">修改</a>
			<a href="../TypeServlet?operate=del&id=<%=model.getId() %>">删除</a>
		</td>
	</tr>
	<%
		}
	%>
</table>
</body>
</html>