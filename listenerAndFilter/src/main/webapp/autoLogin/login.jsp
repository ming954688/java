<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/1/7
  Time: 4:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
欢迎登录 <br>
<form action="/LoginServlet">
    用户名: <input type="text" name="username"><br>
    密码: <input type="password" name="password"> <br>
    <input type="checkbox" name="auto_login" value="on">自动登录 <br>
    <input type="submit" value="登录">
</form>
</body>
</html>
