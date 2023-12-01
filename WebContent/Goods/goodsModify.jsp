<%@page import="dao.TypeDao"%>
<%@page import="java.util.Iterator"%>
<%@page import="vo.Type"%>
<%@page import="java.util.List"%>
<%@page import="vo.Goods"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看商品详细</title>
<link rel="stylesheet" type="text/css" href="../CSS/detailTable.css">
</head>
<%
	Goods model=(Goods)request.getSession().getAttribute("SelectedGoodsInfo");
	List<Type> li = new TypeDao().query("");
	Iterator<Type> it = li.iterator();
	String selected=null;
%>
<body>
<form action="../GoodsServlet" method="post">
<table>
	<tr>
		<th colspan="4">商品信息</th>
	</tr>
	<tr>
		<td class="objName">商品名称</td>
		<td><input type="text" name="goodsname" value="<%=model.getGoodsname() %>" /></td>
		<td class="objName" >商品编号</td>
		<td><%=model.getGoodsid() %></td>
	</tr>
	<tr>
		<td class="objName">商品简介</td>
		<td colspan="3"><input type="text" name="summary" value="<%=model.getSummary() %>" /></td>
	</tr>
	<tr>
		<td class="objName" >品牌</td>
		<td><input type="text" name="brand" value="<%=model.getBrand() %>" /></td>
		<td class="objName">原产地</td>
		<td><input type="text" name="place" value="<%=model.getPlace() %>" /></td>
	</tr>
	<tr>
		<td class="objName" >价格</td>
		<td><input id="cutWidthInput" type="text" name="price" value="<%=model.getPrice() %>" />&nbsp;元</td>
		<td class="objName">折扣</td>
		<td><input id="cutWidthInput" type="text" name="discount" value="<%=model.getDiscount() %>" />&nbsp;折</td>
	</tr>
	<tr>
		<td class="objName">商品图片</td>
		<td colspan="3"><input type="text" name="picPath" value="<%=model.getPicPath() %>" /></td>
	</tr>
	<tr>
		<td class="objName" >商品类型</td>
		<td>
			<select name="typeId">
				<%
				while(it.hasNext()){
					Type t=it.next();
					if(model.getTypeId()==t.getId())selected="selected=\"selected\"";
				%>
				<option value="<%=t.getId() %>" ><%=t.getTypeName() %></option>
				<%
				}
				%>
			</select>
		</td>
		<td class="objName">添加日期</td>
		<td><%=model.getAddDate() %></td>
	</tr>
	<tr>
		<td class="objName">商品数量</td>
		<td colspan="3" class="tooWidenBar"><input id="cutWidthInput" type="text" name="goodssum" value="<%=model.getGoodssum() %>" />&nbsp;件</td>
	</tr>
	<tr>
		<td colspan="4" class="buttonBar">
			<input type="submit" value="修改" class="buttonStyle">
			<input type="reset" value="重置" class="buttonStyle">
			<input type="button" value="返回" class="buttonStyle" onclick="redictToQuery()">
		</td>
	</tr>
</table>
<input type="hidden" name="goodsid" value="<%=model.getGoodsid() %>"/>
<input type="hidden" value="modify" name="operate">
</form>
</body>
<script type="text/javascript">
function redictToQuery(){
	window.location="../GoodsServlet?operate=query&clear=SelectedGoodsInfo";
}
</script>
</html>