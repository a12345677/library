<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
<%--<base href="http://localhost:8080/BookStore02/">--%>
<%--<link type="text/css" rel="stylesheet" href="static/css/style.css" >--%>
	<%@ include file="/pages/common/head.jsp"%>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">购物车</span>
<%--			<div>--%>
<%--				<span>欢迎<span class="um_span">韩总</span>光临尚硅谷书城</span>--%>
<%--				<a href="pages/order/order.jsp">我的订单</a>--%>
<%--				<a href="index.jsp">注销</a>&nbsp;&nbsp;--%>
<%--				<a href="index.jsp">返回</a>--%>
<%--			</div>--%>
		<%@ include file="/pages/common/common.jsp"%>
		<script type="text/javascript">
			$(function () {
				$(".delete").click(function () {
					return confirm("确定要删除《" + $(this).parent().parent().find("td:first").text() + "》吗?")
				})
				$(".clear").click(function () {
					return confirm("确定要清空购物车吗?")
				})
				$(".update").change(function () {
					var name = $(this).parent().parent().find("td:first").text();
					var value = this.value;
					var bookId = $(this).attr("bookId");
					if(confirm("确定要将商品《" + name + "》数量修改为 "+ value +" 吗?")){
						location.href="http://localhost:8080/project/CartServlet?action=update&count="+value+"&id="+bookId;
					}
					else {
						this.value = this.defaultValue;
					}
				})
			})
		</script>
	</div>


	<div id="main">
	
		<table>
			<tr>
				<td>商品名称</td>
				<td>数量</td>
				<td>单价</td>
				<td>金额</td>
				<td>操作</td>
			</tr>

			<c:if test="${cart == null || cart.totalCount == 0}">
				<tr>
					<td colspan="5">
						<a href="/project/">
							亲！购物车为空，快去购物吧！
						</a>

					</td>
				</tr>
			</c:if>

			<c:forEach items="${cart.items}" var="entry">
				<tr>
					<td>${entry.value.name}</td>
					<td>
						<input type="text" value="${entry.value.count}" style="width: 40px" class="update" bookId="${entry.value.id}">
					</td>
					<td>${entry.value.price}</td>
					<td>${entry.value.totalPrice}</td>
					<td><a href="CartServlet?action=delete&id=${entry.key}" class="delete">删除</a></td>
				</tr>
			</c:forEach>

			
		</table>

		<c:if test="${cart != null && cart.totalCount != 0}">
			<div class="cart_info">
				<span class="cart_span">购物车中共有<span class="b_count">${cart.totalCount}</span>件商品</span>
				<span class="cart_span">总金额<span class="b_price">${cart.totalPrice}</span>元</span>
				<span class="cart_span"><a href="CartServlet?action=clear" class="clear">清空购物车</a></span>
				<span class="cart_span"><a href="pages/cart/checkout.jsp">去结账</a></span>
			</div>
		</c:if>

	
	</div>
	
<%--	<div id="bottom">--%>
<%--		<span>--%>
<%--			尚硅谷书城.Copyright &copy;2015--%>
<%--		</span>--%>
<%--	</div>--%>
	<%@ include file="/pages/common/footer.jsp"%>
</body>
</html>