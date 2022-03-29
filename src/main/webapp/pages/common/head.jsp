<%--
  Created by IntelliJ IDEA.
  User: 吴梭权
  Date: 2022/1/26
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme()
            + "://"
            + request.getServerName()
            + ":"
            + request.getServerPort()
            + request.getContextPath()
            +"/";
    request.setAttribute("basePath",basePath);
%>

<base href="<%=basePath%>"/>
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
<script src="Script/jquery.js"></script>
<script src="Script/axios.js"></script>
