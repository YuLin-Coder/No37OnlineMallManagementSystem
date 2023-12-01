<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录界面</title>
<link rel="stylesheet" type="text/css" href="../CSS/detailTable.css">
</head>
<%
	if(session.getAttribute("loginUserinfo")!=null){
		session.invalidate();
	}
%>
<body>
<form action="../UserServlet" method="post">
<table>
	<tr>
		<th colspan="2">欢迎来到在线商城</th>
	</tr>
	<tr>
		<td class="objName">用户名</td>
		<td><input type="text" name="username" /></td>
	</tr>
	<tr>
		<td class="objName">密码</td>
		<td><input type="password" name="password" /></td>
	</tr>
	<tr>
		<td colspan="2" class="buttonBar">
			<input type="submit"  class="buttonStyle" />
			<input type="reset"  class="buttonStyle" />
			<input type="button"  class="buttonStyle" onclick="register()" value="注册"/>
		</td>
	</tr>
</table>
<input type="hidden" name="operate" value="login" />
</form> 
</body>
<script type="text/javascript">
function register(){
	window.location.href="./register.jsp";
}
</script>
</html>