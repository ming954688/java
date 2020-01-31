<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/1/2
  Time: 20:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    pageContext.setAttribute("name","pageContext");
    request.setAttribute("name","request");
    session.setAttribute("name","session");
    application.setAttribute("name","application");
%>

${pageScope.name} <br>
${requestScope.name}<br>
${sessionScope.name }<br>
${applicationScope.name }<br>

<hr>
<%
    String[] a = {"aa","bb","cc","dd"};
    pageContext.setAttribute("array",a);
%>

${array[0]},${array[1]}

<hr>
<%
    ArrayList list = new ArrayList();
    list.add("aa");
    list.add("bb");
    pageContext.setAttribute("li",list);
%>

${li[0] },${li[1] }

<hr>
<%
    HashMap hashMap = new HashMap();
    hashMap.put("name","张三");
    hashMap.put("age",23);
    pageContext.setAttribute("person",hashMap);
%>

${person.name}
${person.age}

</body>
</html>
