<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="dao.TypeDao"%>
<%@page import="vo.Type"%>
<%@page import="java.util.Date"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加商品</title>
<link rel="stylesheet" type="text/css" href="../CSS/detailTable.css">
</head>
<%
	List<Type> li=new TypeDao().query("");
	Iterator<Type> it=li.iterator();
%>
<body>
<form action="../GoodsServlet" method="post" name="addform">
<table>
	<tr>
		<th colspan="4">添加商品</th>
	</tr>
	<tr>
		<td class="objName">商品名称</td>
		<td><input type="text" name="goodsname" value="" /></td>
		<td class="objName" >商品编号</td>
		<td>待分配</td>
		<tr>
		<td class="objName">商品简介</td>
		<td colspan="3"><input type="text" name="summary" value="" /></td>
	</tr>
	<tr>
		<td class="objName" >品牌</td>
		<td><input type="text" name="brand" value="" /></td>
		<td class="objName">原产地</td>
		<td><input type="text" name="place" value="" /></td>
	</tr>
	<tr>
		<td class="objName" >价格</td>
		<td><input id="cutWidthInput" type="text" name="price" value="" />&nbsp;元</td>
		<td class="objName">折扣</td>
		<td><input id="cutWidthInput" type="text" name="discount" value="" />&nbsp;折</td>
	</tr>
	<tr>
		<td class="objName">商品图片</td>
		<td colspan="3"><input type="text" name="picPath" value="" /></td>
	</tr>
	<tr>
		<td class="objName" >商品类型</td>
		<td>
			<select name="typeId">
				<%
				while(it.hasNext()){
					Type model=it.next();
				%>
				<option value="<%=model.getId() %>" ><%=model.getTypeName() %></option>
				<%
				}
				%>
			</select>
		</td>
		<!-- <td><input type="text" name="typeId" value="" /></td> -->
		<td class="objName">添加日期</td>
		<td><%=new Timestamp(new Date().getTime()).toString() %></td>
	</tr>
	<tr>
		<td class="objName">商品数量</td>
		<td colspan="3" class="tooWidenBar"><input id="cutWidthInput" type="text" name="goodssum" value="" />&nbsp;件</td>
	</tr>
	<tr>
		<td colspan="4" class="buttonBar">
			<input type="submit" value="添加" class="buttonStyle">
			<input type="reset" value="重置" class="buttonStyle">
		</td>
	</tr>
</table>
<input type="hidden" name="operate" value="add"/>
</form>
</body>
</html>