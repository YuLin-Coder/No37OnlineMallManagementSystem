<%@page import="java.util.Date"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.util.Iterator"%>
<%@page import="vo.Goods"%>
<%@page import="dao.GoodsDao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加订单</title>
<link rel="stylesheet" type="text/css" href="../CSS/detailTable.css">
</head>
<%
	List<Goods> li=new GoodsDao().query("");
	Iterator<Goods> it=li.iterator();
	
	String orderDate=new Timestamp(new Date().getTime()).toString();
%>
<body>
待完成
</body>
</html>