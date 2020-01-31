# jsp
> 全称: java server page      
* 什么是jsp        
  其实就是一个网页, 底层是一个java类, 它继承了servlet, 可以说就是一个servlet
  
* 为什么会有jsp?      
html多数情况下, 用来显示静态内容, 一成不变的, 有时候要在网页上显示动态的数据,
这些动作需要查询数据库,然后在网页上显示, html不支持写java代码,
jsp中可以写java代码.

## jsp的三大指令
*  page     

        1. extends 用于指定jsp翻译成java文件后, 继承的父类是谁, 一般不需要更改
        2. import  导包使用,一般不用手写
        3. session 用于控制在这个jsp页面中, 能够直接使用session对象, true/false
        4. errorPage  指定出现错误后, 跳转的页面
        5. isErrorPage  在指定的错误页面中使用, 可以直接使用exception对象.
        
* include       
  包含另一个jsp的内容进来.        
  会将另一个页面的所有内容拿过来一起输出. 所有的标签元素都包含进来.
  ```
  <%@include file="Demo2.jsp"%>
  ```
  [eg:](file:///G:\cache\idea\java\jspDemo\src\main\webapp\page&include\Demo1.jsp)

  
*  taglib       
   ```
   <% taglib prefix="" uri=""%> 
   prefix: 标签库的别名
   uri: 标签库的路径
   ```
   
## jsp动作标签
1. 包含一个页面的内容, (拿过来的是运行后的结果)      
   <jsp:include page=" "></jsp:include>
2. 请求转发      
   <jsp:forward page="Demo3.jsp"></jsp:forward>
3. 在包含某个页面的时候, 或者在跳转某个页面的时候, 加入这个参数     
   <jsp:param name="" value=""/>
   
   [eg: ](file:///G:\cache\idea\java\jspDemo\src\main\webapp\jsp_action\Demo1.jsp)

## jsp内置对象
> 所谓的内置对象就是我们可以直接在jsp页面中使用这些对象,不需要创建.       

   [图片笔记](file:///G:\cache\idea\java\jspDemo\Snipaste_2020-01-02_18-32-02.png)          

作用域对象举例:        
[eg: ](file:///G:\cache\idea\java\jspDemo\src\main\webapp\builtInObject\Demo1.jsp)          

out对象和response 对象, 总是response对象输出的内容在前面显示. 
[eg:](file:///G:\cache\idea\java\jspDemo\src\main\webapp\builtInObject\Demo4.jsp)



# el表达式
> 为了简化jsp代码, 就是为了简化在jsp中写的java代码
格式:         
${表达式 }     一般用于从一个对象中取出它的属性值, 如取出某一个学生的姓名.
* 使用方法:     
    1. 取出四个作用域中存储的值     
    [eg: ](file:///G:\cache\idea\java\jspDemo\src\main\webapp\el\Demo1.jsp)

    2. 取值方式:        
    如果这份值是有下标的. 直接使用 " [] "      
    如果没有下标, 直接使用" .  "
    
* el表达式的11个内置对象
1. pageContext
2. pageScope
3. requestScope
4. sessionScope
5. applicationScope
6. header
7. headerValues
8. param
9. params
10. cookie
11. initParam


# jstl
> 全称Jsp Standard Tag Library 简化jsp的代码编写, 一般和el表达式结合使用

## 怎么用
1. 导入jar文件, jstl.jar,  standard.jar
2. 在页面上使用taglib引入       
```
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
```
3. 常用标签: 
```
<c:set></c:set>: 申明一个对象, 存储在域中, 默认是pageScope
<c:if test="" var="" scope=""></c:if>       
 test中的表达式如果为true, 则执行if之间的代码  var用于接收test表达式的结果, scope将这个结果存在哪一个作用域中.
```

```
<c:forEach begin="1" end="10" var="i" step="2">
    ${i}
</c:forEach>
从1开始遍历到10, 得到的结果赋值给i, step表示步数      
上面的结果是: 1, 3, 5, 7, 9
```













   