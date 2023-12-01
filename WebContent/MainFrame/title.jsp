<%@page import="vo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页标题</title>
<style type="text/css">
* {
	margin: 0;
}

h1 {
	text-align: center;
}
</style>
</head>
<%
	User model = (User) session.getAttribute("loginUserinfo");
	boolean isAdmin = "1".equals(model.getUserType());
	String showName;
	if(isAdmin){
		showName="后台管理员\"";
	} else {
		showName="尊敬的顾客\"";
	}
	showName+=model.getRealname();
%>
<body>
	用户编号：<%=model.getId()%>
	<h1>
		<%=showName%>"您好！
	</h1>
</body>
</html>