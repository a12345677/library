<%--
  Created by IntelliJ IDEA.
  User: 吴梭权
  Date: 2022/1/29
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>书城首页</title>
    <%--<link type="text/css" rel="stylesheet" href="static/css/style.css" >--%>
    <%@ include file="/pages/common/head.jsp"%>
    <script type="text/javascript">
        $(function () {
            $(".addToCart").click(function () {
                alert("1111")
                location.href = "http://localhost:8080/project/CartServlet?action=add"
            })
            $("#trans").click(function () {
                var $pnInput = $("#pn_input").val();
                if ($pnInput > 0 && $pnInput <= ${page.pageTotal})
                    location.href = "http://localhost:8080/project/BookServlet?action=pageByPrice&pageNo=" + $pnInput + "&min=${min}&max=${max}";
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
    <span class="wel_word">网上书城</span>
    <div>
        <c:if test="${sessionScope.username == null}">
            <a href="pages/user/login.jsp">登录</a> |
            <a href="pages/user/regist.jsp">注册</a> &nbsp;&nbsp;
        </c:if>
        <c:if test="${sessionScope.username != null}">
            <span>欢迎<span class="um_span">${sessionScope.username}</span>光临尚硅谷书城</span>
            <a href="/project/UserServlet?action=logout">注销</a> &nbsp;&nbsp;
        </c:if>
        <a href="pages/cart/cart.jsp">购物车</a>
        <a href="pages/manager/manager.jsp">后台管理</a>
    </div>
</div>
<div id="main">
    <div id="book">
        <div class="book_cond">
            <form action="/project/BookServlet?action=pageByPrice" method="post">
                <c:if test="${min == -1}">
                    价格：<input id="min" type="text" name="min" value=""> 元 -
                </c:if>
                <c:if test="${min != -1}">
                    价格：<input id="min" type="text" name="min" value="${min}"> 元 -
                </c:if>
                <c:if test="${max == 2147483647}">
                    <input id="max" type="text" name="max" value=""> 元
                </c:if>
                <c:if test="${max != 2147483647}">
                    <input id="max" type="text" name="max" value="${max}"> 元
                </c:if>
                <input type="submit" value="查询" />
            </form>
        </div>
        <div style="text-align: center">
            <span>您的购物车中有3件商品</span>
            <div>
                您刚刚将<span style="color: red">时间简史</span>加入到了购物车中
            </div>
        </div>
        <c:forEach items="${page.items}" var="book">
            <div class="b_list">
                <div class="img_div">
                    <img class="book_img" alt="" src="${book.imgPath}" />
                </div>
                <div class="book_info">
                    <div class="book_name">
                        <span class="sp1">书名:</span>
                        <span class="sp2">${book.name}</span>
                    </div>
                    <div class="book_author">
                        <span class="sp1">作者:</span>
                        <span class="sp2">${book.author}</span>
                    </div>
                    <div class="book_price">
                        <span class="sp1">价格:</span>
                        <span class="sp2">￥${book.price}</span>
                    </div>
                    <div class="book_sales">
                        <span class="sp1">销量:</span>
                        <span class="sp2">${book.sales}</span>
                    </div>
                    <div class="book_amount">
                        <span class="sp1">库存:</span>
                        <span class="sp2">${book.stock}</span>
                    </div>
                    <div class="book_add">
                        <button class="addToCart">加入购物车</button>
                    </div>
                </div>
            </div>
        </c:forEach>

    </div>

<%--    <div id="page_nav">--%>
<%--        <a href="#">首页</a>--%>
<%--        <a href="#">上一页</a>--%>
<%--        <a href="#">3</a>--%>
<%--        【4】--%>
<%--        <a href="#">5</a>--%>
<%--        <a href="#">下一页</a>--%>
<%--        <a href="#">末页</a>--%>
<%--        共10页，30条记录 到第<input value="4" name="pn" id="pn_input"/>页--%>
<%--        <input type="button" value="确定">--%>
<%--    </div>--%>

    <div id="page_nav">
        <c:if test="${page.pageNo-1 > 0}">
            <a href="/project/BookServlet?action=pageByPrice&pageNo=1&min=${min}&max=${max}">首页</a>
            <a href="/project/BookServlet?action=pageByPrice&pageNo=${page.pageNo-1}&min=${min}&max=${max}">上一页</a>
        </c:if>
        <c:if test="${page.pageNo-1 == 0}">
            <a href="/project/BookServlet?action=pageByPrice&pageNo=1&min=${min}&max=${max}">首页</a>
            <a href="/project/BookServlet?action=pageByPrice&pageNo=1&min=${min}&max=${max}">上一页</a>
        </c:if>

        【${page.pageNo}】
        <c:if test="${page.pageNo == page.pageTotal}">
            <a href="/project/BookServlet?action=pageByPrice&pageNo=${page.pageTotal}&min=${min}&max=${max}">下一页</a>
            <a href="/project/BookServlet?action=pageByPrice&pageNo=${page.pageTotal}&min=${min}&max=${max}">末页</a>
        </c:if>
        <c:if test="${page.pageNo < page.pageTotal}">
            <a href="/project/BookServlet?action=pageByPrice&pageNo=${page.pageNo+1}&min=${min}&max=${max}">下一页</a>
            <a href="/project/BookServlet?action=pageByPrice&pageNo=${page.pageTotal}&min=${min}&max=${max}">末页</a>
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