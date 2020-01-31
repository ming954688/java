<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/1/1
  Time: 20:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>您的购物车商品如下:</h2>
<%
    Map<String,Integer> cartMap = (Map<String, Integer>) session.getAttribute("cart");
    if(cartMap != null){
        for (String key : cartMap.keySet()) {
            Integer integer = cartMap.get(key);
%>

<h3>名称: <%=key%> 数量:<%=integer%></h3>
<%

        }
    }
%>

<a href="/CleanCart">清空购物车</a>


</body>
</html>
