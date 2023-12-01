<%@page import="vo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>菜单栏</title>
<link rel="stylesheet" type="text/css" href="../CSS/menuStyle.css">
</head>
<%
	User model=(User)session.getAttribute("loginUserinfo");
	boolean isAdmin="1".equals(model.getUserType());
%>
<body>
<input class="topButton" type="button" value="查看商品" onclick="goodsQuery()"><br />
<input type="button" value="查看商品类型" onclick="typeQuery()"><br />
<input type="button" value="查看订单" onclick="ordersQuery()"><br />
<%
	if(isAdmin){
%>
<input type="button" value="添加商品" onclick="goodsAdd();"><br/>
<input type="button" value="添加商品类型" onclick="typeAdd()"><br />
<input type="button" value="添加订单" onclick="ordersAdd()"><br />
<input type="button" value="查看用户" onclick="userQuery()"><br />
<%
	}
%>
<input type="button" value="退出登录" onclick="logout()"><br />
</body>
<script type="text/javascript">
var conwin=top.frames['content'];//从父级页面获取名为content的frame窗口
function goodsAdd(){
	conwin.location.href="../Goods/goodsAdd.jsp";
}
function goodsQuery(){
	conwin.location.href="../GoodsServlet?operate=query";
}
function typeAdd(){
	conwin.location.href="../Type/typeAdd.jsp";
}
function typeQuery(){
	conwin.location.href="../TypeServlet?operate=query";
}
function ordersAdd(){
	conwin.location.href="../Orders/ordersAdd.jsp";
}
function ordersQuery(){
	conwin.location.href="../OrdersServlet?operate=query";
}
function userQuery(){
	conwin.location.href="../UserServlet?operate=query";
}
function logout(){
	top.location.href="../User/login.jsp";
}
</script>
</html>