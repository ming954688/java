<%@ page import="java.util.ArrayList" %>
<%@ page import="com.User" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/1/2
  Time: 21:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%-- String name = "张三"  会将这个对象存在域中 --%>
<c:set var="name" value="张三" scope="session"></c:set>

${sessionScope.name}

<hr>-------------------------------------------------------
<c:set var="age" value="17"></c:set>


<c:if test="${age>16}" var="flag" scope="session">
    年龄大于16岁
</c:if>

${sessionScope.flag}

<hr>-------------------------------------------------------
<c:forEach begin="1" end="10" var="i" step="2">
    ${i}
</c:forEach>

<hr>-------------------------------------------------------
<%
    ArrayList arrayList = new ArrayList();
    arrayList.add(new User("ming",34));
    arrayList.add(new User("tong",24));
    arrayList.add(new User("sheng",25));
    pageContext.setAttribute("users",arrayList);
%>

<%-- items表示域中存储的对象. 要用el表达式取出来.
     var表示遍历出来的每一个元素使用 user去接收
 --%>
<c:forEach  var="user" items="${users}">
    ${user.name} = ${user.age} <br>
</c:forEach>



</body>
</html>
