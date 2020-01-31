<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/1/7
  Time: 4:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${not empty user}">
    欢迎您: ${user.username}
</c:if>

<c:if test="${empty user}">
    <a href="/autoLogin/login.jsp">请先登录</a>
</c:if>

</body>
</html>
