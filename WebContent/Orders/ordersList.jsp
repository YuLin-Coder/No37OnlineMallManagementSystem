<%@page import="java.util.Iterator"%>
<%@page import="vo.Orders"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询订单</title>
<link rel="stylesheet" type="text/css" href="../CSS/queryTable.css">
</head>
<%
	@SuppressWarnings("unchecked")
	List<Orders> li=(List<Orders>)session.getAttribute("OrdersList");
	Iterator<Orders> it=li.iterator();
%>
<body>
<table>
	<tr class="title">
			<td>订单编号</td>
			<td>订单生成日期</td>
			<td>商品名</td>
			<td>数量</td>
			<td>付款方式</td>
			<td>运送方式</td>
			<td>用户姓名</td>
			<td>发货状态</td>
			<td>总价</td>
			<td class="col_operate">操作</td>
    </tr>
    <%
		while(it.hasNext()){
			Orders model=it.next();
	%>
	<tr class="list">
		<td><%=model.getId() %></td>
		<td><%=model.getOrderDate() %></td>
		<td><%=model.getGoodsName() %></td>
		<td><%=model.getAmount() %></td>
		<td><%=model.getPayType() %></td>
		<td><%=model.getTransportType() %></td>
		<td><%=model.getUserName() %></td>
		<td><%=model.getZhuang() %></td>
		<td><%=model.getMoney() %></td>
		<td>
			<a href="../OrdersServlet?operate=getModel&page=detail&id=<%=model.getId() %>">查看详细</a>
			<a href="../OrdersServlet?operate=getModel&page=modify&id=<%=model.getId() %>">修改</a>
			<a href="../OrdersServlet?operate=del&id=<%=model.getId() %>">删除</a>
		</td>
	</tr>
	<%
		}
	%>
</table>
</body>
</html>