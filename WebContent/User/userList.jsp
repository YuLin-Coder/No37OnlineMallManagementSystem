<%@page import="java.util.Iterator"%>
<%@page import="vo.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询用户</title>
<link rel="stylesheet" type="text/css" href="../CSS/queryTable.css">
</head>
<%
	@SuppressWarnings("unchecked")
	List<User> li=(List<User>)session.getAttribute("UserList");
	Iterator<User> it=li.iterator();
%>
<body>
<table>
	<tr class="title">
			<td>用户编号</td>
			<td>用户名</td>
			<td>真实名</td>
			<td>性别</td>
			<td>用户类型</td>
			<td>注册日期</td>
			<td>城市</td>
			<td>邮箱地址</td>
			<td>联系方式</td>
			<td class="col_operate">操作</td>
    </tr>
    <%
		while(it.hasNext()){
			User model=it.next();
	%>
	<tr class="list">
		<td><%=model.getId() %></td>
		<td><%=model.getUsername() %></td>
		<td><%=model.getRealname() %></td>
		<td><%=model.getSex() %></td>
		<td><%=model.getUserType() %></td>
		<td><%=model.getAddTime() %></td>
		<td><%=model.getCity() %></td>
		<td><%=model.getEmail() %></td>
		<td><%=model.getNumber() %></td>
		<td>
			<a href="../UserServlet?operate=getModel&page=detail&id=<%=model.getId() %>">查看详细</a>
			<a href="../UserServlet?operate=getModel&page=modify&id=<%=model.getId() %>">修改</a>
			<a href="../UserServlet?operate=del&id=<%=model.getId() %>">删除</a>
		</td>
	</tr>
	<%
		}
	%>
</table>
</body>
</html>