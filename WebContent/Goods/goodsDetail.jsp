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
	Goods model=(Goods)session.getAttribute("SelectedGoodsInfo");
%>
<body>
<table>
	<tr>
		<th colspan="4">商品详细</th>
	</tr>
	<tr>
		<td class="objName">商品名称</td>
		<td><%=model.getGoodsname() %></td>
		<td class="objName" >商品编号</td>
		<td><%=model.getGoodsid() %></td>
	</tr>
	<tr>
		<td class="objName">商品简介</td>
		<td colspan="3"><%=model.getSummary() %></td>
	</tr>
	<tr>
		<td class="objName" >品牌</td>
		<td><%=model.getBrand() %></td>
		<td class="objName">原产地</td>
		<td><%=model.getPlace() %></td>
	</tr>
	<tr>
		<td class="objName" >价格</td>
		<td><%=model.getPrice() %>&nbsp;元</td>
		<td class="objName">折扣</td>
		<td><%=model.getDiscount() %>&nbsp;折</td>
	</tr>
	<tr>
		<td class="objName">商品图片</td>
		<td colspan="3"><img alt="" src="<%=model.getPicPath() %>"></td>
	</tr>
	<tr>
		<td class="objName" >商品类型名称</td>
		<td><%=model.getTypeName() %></td>
		<td class="objName">添加日期</td>
		<td><%=model.getAddDate() %></td>
	</tr>
	<tr>
		<td class="objName">商品数量</td>
		<td colspan="3" class="tooWidenBar"><%=model.getGoodssum() %>&nbsp;件</td>
	</tr>
	<tr>
		<td colspan="4" class="buttonBar"><input type="button" value="返回" class="buttonStyle" onclick="redictToQuery()"></td>
	</tr>
</table>
<!-- 
<table>
	<tr>
		<th colspan="4">商品详细</th>
	</tr>
	<tr>
		<td class="objName" >商品编号</td>
		<td></td>
		<td class="objName">商品名称</td>
		<td></td>
	</tr>
	<tr>
		<td class="objName">商品简介</td>
		<td colspan="3"></td>
	</tr>
	<tr>
		<td class="objName" >品牌</td>
		<td></td>
		<td class="objName">原产地</td>
		<td></td>
	</tr>
	<tr>
		<td class="objName" >价格</td>
		<td>&nbsp;元</td>
		<td class="objName">折扣</td>
		<td></td>
	</tr>
	<tr>
		<td class="objName">商品图片</td>
		<td colspan="3"></td>
	</tr>
	<tr>
		<td class="objName" >商品类型名称</td>
		<td>&nbsp;元</td>
		<td class="objName">添加日期</td>
		<td></td>
	</tr>
	<tr>
		<td class="objName">商品数量</td>
		<td colspan="3" class="tooWidenBar">&nbsp;件</td>
	</tr>
	<tr>
		<td colspan="4" class="buttonBar"><input type="button" value="返回" class="buttonStyle" onclick="redictToQuery()"></td>
	</tr>
</table>
 -->
</body>
<script type="text/javascript">
function redictToQuery(){
	window.location="../GoodsServlet?operate=query";
}
</script>
</html>