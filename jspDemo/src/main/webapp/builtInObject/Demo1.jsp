<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/1/2
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
使用作用域存储数据
<hr>
<%
    pageContext.setAttribute("name","pageContext");
    request.setAttribute("name","request");
    session.setAttribute("name","session");
    application.setAttribute("name","application");
%>

<%=pageContext.getAttribute("name")%> <br>
<%=request.getAttribute("name")%><br>
<%=session.getAttribute("name")%><br>
<%=application.getAttribute("name")%><br>
<%--跳转到下一个页面--%>
<%--
<jsp:forward page="Demo2.jsp"></jsp:forward>
--%>
<%
    response.sendRedirect("./Demo3.jsp");
%>
</body>
</html>
