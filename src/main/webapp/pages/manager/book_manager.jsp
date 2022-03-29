<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书管理</title>
<%--<link type="text/css" rel="stylesheet" href="../../static/css/style.css" >--%>
	<%@ include file="/pages/common/head.jsp"%>
	<script type="text/javascript">
		$(function () {
			$(".delete").click(function () {
				return confirm("确定删除《" + $(this).parent().parent().find("td:first").text() + "》？")
			})
			$("#trans").click(function () {
				var $pnInput = $("#pn_input").val();
				if ($pnInput > 0 && $pnInput <= ${page.pageTotal})
				location.href = "http://localhost:8080/project/BookServlet?action=page&pageNo=" + $pnInput;
				else {
					alert("请输入正确页面")
				}
			})
		})
	</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">图书管理系统</span>
<%--			<div>--%>
<%--				<a href="book_manager.jsp">图书管理</a>--%>
<%--				<a href="order_manager.jsp">订单管理</a>--%>
<%--				<a href="../../index.jsp">返回商城</a>--%>
<%--			</div>--%>
		<%@ include file="/pages/common/manager.jsp"%>
	</div>
	
	<div id="main">
		<table>
			<tr>
				<td>名称</td>
				<td>价格</td>
				<td>作者</td>
				<td>销量</td>
				<td>库存</td>
				<td colspan="2">操作</td>
			</tr>
			<c:forEach items="${page.items}" var="book">
				<tr>
					<td>${book.name}</td>
					<td>${book.price}</td>
					<td>${book.author}</td>
					<td>${book.sales}</td>
					<td>${book.stock}</td>
					<td><a href="/project/BookServlet?action=selectById&&id=${book.id}">修改</a></td>
					<td><a href="/project/BookServlet?action=deleteById&&id=${book.id}" class="delete">删除</a></td>
				</tr>
			</c:forEach>

			
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="pages/manager/book_edit.jsp">添加图书</a></td>
			</tr>	
		</table>
		<div id="page_nav">
			<c:if test="${page.pageNo-1 > 0}">
				<a href="/project/BookServlet?action=page&pageNo=1">首页</a>
				<a href="/project/BookServlet?action=page&pageNo=${page.pageNo-1}">上一页</a>
			</c:if>
			<c:if test="${page.pageNo-1 == 0}">
				<a href="/project/BookServlet?action=page&pageNo=1">首页</a>
				<a href="/project/BookServlet?action=page&pageNo=1">上一页</a>
			</c:if>

			【${page.pageNo}】
			<c:if test="${page.pageNo == page.pageTotal}">
				<a href="/project/BookServlet?action=page&&pageNo=${page.pageTotal}">下一页</a>
				<a href="/project/BookServlet?action=page&pageNo=${page.pageTotal}">末页</a>
			</c:if>
			<c:if test="${page.pageNo < page.pageTotal}">
				<a href="/project/BookServlet?action=page&&pageNo=${page.pageNo+1}">下一页</a>
				<a href="/project/BookServlet?action=page&pageNo=${page.pageTotal}">末页</a>
			</c:if>

			共${page.pageTotal}页，${page.pageTotalCount}条记录 到第<input value="${page.pageNo}" name="pn" id="pn_input"/>页
			<input type="button" value="确定" id="trans">
		</div>
	</div>

<%--	<div id="bottom">--%>
<%--		<span>--%>
<%--			尚硅谷书城.Copyright &copy;2015--%>
<%--		</span>--%>
<%--	</div>--%>
	<%@ include file="/pages/common/footer.jsp"%>
</body>
</html>