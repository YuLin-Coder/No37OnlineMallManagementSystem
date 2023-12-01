<%@page import="java.util.Date"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
<link rel="stylesheet" type="text/css" href="../CSS/detailTable.css">
</head>
<%
	String addTime=new Timestamp(new Date().getTime()).toString();
%>
<body>
<form action="../UserServlet" method="post">
<table>
	<tr>
		<th colspan="4">注册新用户</th>
	</tr>
	<tr>
		<td class="objName">用户名</td>
		<td><input type="text" name="username" value="" /></td>
		<td class="objName" >用户编号</td>
		<td>待分配</td>
	</tr>
	<tr>
		<td class="objName">密码</td>
		<td><input type="password" name="password" value="" /></td>
		<td class="objName" >确认密码</td>
		<td><input type="password" name="repassword" value="" /></td>
	</tr>
	<tr>
		<td class="objName">真实名</td>
		<td><input type="text" name="realname" value="" /></td>
		<td class="objName" >性别</td>
		<td>
			<input type="radio" name="sex" value="1" checked="checked">男&nbsp;&nbsp;
			<input type="radio" name="sex" value="0">女&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		</td>
		<!-- <td><input type="text" name="sex" value="" /></td> -->
	</tr>
	<tr>
		<td class="objName">证件类型</td>
		<td><input type="text" name="papersType" value="" /></td>
		<td class="objName" >证件号</td>
		<td><input type="text" name="papersNO" value="" /></td>
	</tr>
	<tr>
		<td class="objName">电话号码</td>
		<td><input type="text" name="number" value="" /></td>
		<td class="objName" >邮箱地址</td>
		<td><input type="text" name="email" value="" /></td>
	</tr>
	<tr>
		<td class="objName">所在城市</td>
		<td><input type="text" name="city" value="" /></td>
		<td class="objName" >添加时间</td>
		<td><%=addTime %></td>
	</tr>
	<tr>
		<td class="objName">联系地址</td>
		<td colspan="3"><input type="text" name="address" value="" /></td>
	</tr>
	<tr>
		<td colspan="4" class="buttonBar">
			<input type="submit" value="注册" class="buttonStyle">
			<input type="reset" value="重置" class="buttonStyle">
			<input type="button" value="返回" onclick="login()" class="buttonStyle">
		</td>
	</tr>
</table>
<input type="hidden" name="addTime" value="<%=addTime %>" />
<input type="hidden" name="userType" value="0" />
<input type="hidden" name="operate" value="add" />
</form>
</body>
<script type="text/javascript">
function login(){
	window.location.href="./login.jsp";
}
</script>
</html>