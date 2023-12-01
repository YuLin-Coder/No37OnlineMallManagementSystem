<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页面</title>
</head>
<frameset rows="100px,*" >
	<frame src="./title.jsp" noresize="noresize">
	<frameset cols="150px,*">
		<frame src="./menu.jsp" noresize="noresize">
		<frame src="./welcome.jsp" name="content" noresize="noresize">
	</frameset>
</frameset>
</html>