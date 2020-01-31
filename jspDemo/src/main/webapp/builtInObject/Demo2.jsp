<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/1/2
  Time: 17:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
这是demo2的内容
<hr>
<%=pageContext.getAttribute("name")%>   &nbsp;&nbsp;&nbsp;说明pageContext的作用域只有当前页面 <br>
<%=request.getAttribute("name")%><br>
<%=session.getAttribute("name")%><br>
<%=application.getAttribute("name")%><br>
</body>
</html>
