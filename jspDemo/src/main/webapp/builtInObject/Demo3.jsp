<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/1/2
  Time: 17:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
这是demo3的内容
<hr>
<%=pageContext.getAttribute("name")%> <br>
<%=request.getAttribute("name")%> &nbsp;&nbsp;&nbsp; request的作用域只限于一次请求.
<br>
<%=session.getAttribute("name")%> &nbsp;&nbsp;&nbsp;session的作用域限于一次会话, 关闭客户端,则数据消失   <br>
<%=application.getAttribute("name")%> &nbsp;&nbsp;&nbsp;application的作用域是整个工程, 关闭服务器,数据消失 <br>
</body>
</html>
