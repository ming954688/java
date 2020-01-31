<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/1/2
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
  request.setCharacterEncoding("UTF-8");
%>
这是demo1的内容: <br>
<jsp:include page="Demo2.jsp"></jsp:include>

<jsp:forward page="Demo3.jsp">
    <jsp:param name="name" value="名"/>
</jsp:forward>
<%
    ArrayList<Object> objects = new ArrayList<>();
%>
</body>
</html>
