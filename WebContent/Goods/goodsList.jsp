<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="vo.Goods"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询结果</title>
<link rel="stylesheet" type="text/css" href="../CSS/queryTable.css">
</head>
<%
	@SuppressWarnings("unchecked")
	List<Goods> li=(List<Goods>)session.getAttribute("GoodsList");
	Iterator<Goods> it=li.iterator();
%>
<body>
<table>
	<tr class="title">
			<td>商品编号</td>
			<td>商品名称</td>
			<td class="col_short">简介</td>
			<td>品牌</td>
			<td>原产地</td>
			<td>单价</td>
			<td>折扣</td>
			<td>添加时间</td>
			<td>商品销售总数</td>
			<td>商品类型名称</td>
			<td class="col_operate">操作</td>
    </tr>
	<%
		while(it.hasNext()){
			Goods model=it.next();
	%>
	<tr class="list">
		<td><%=model.getGoodsid() %></td>
		<td><%=model.getGoodsname() %></td>
		<td><%=model.getSummary() %></td>
		<td><%=model.getBrand() %></td>
		<td><%=model.getPlace() %></td>
		<td><%=model.getPrice() %></td>
		<td><%=model.getDiscount() %></td>
		<td><%=model.getAddDate() %></td>
		<td><%=model.getGoodssum() %></td>
		<td><%=model.getTypeName() %></td>
		<td>
			<a href="../GoodsServlet?operate=getModel&page=detail&id=<%=model.getGoodsid() %>">查看详细</a>
			<a href="../GoodsServlet?operate=getModel&page=modify&id=<%=model.getGoodsid() %>">修改</a>
			<a href="../GoodsServlet?operate=del&id=<%=model.getGoodsid() %>">删除</a>
		</td>
	</tr>
	<%
		}
	%>
</table>
</body>
</html>