# 什么是cookie
> 是一份小数据, 是服务器给客户端, 并且存储在客户端的数据

## 应用场景
> 自动登录, 浏览记录. 购物车
## 作用
> 1. http协议是无状态的, 客户端与服务器在通讯的时候是无状态的, 其实就是      
>    客户端在第二次来访的时候, 服务器不知道这个用户之前有没有来访过,      
>    为了更好的用户体验, 更好的交互, 使用cookie

## cookie的简单使用
> 1. 在响应的时候, 添加cookie
> 2. 客户端接收到的消息中, 响应头中多了一个字段"set-cookie"       
> 3. 在客户端第二次访问的时候, 会将cookie携带到服务器, 可以获取     
>    [举例](file:///G:\cache\idea\java\cookieandsession\src\main\java\com\CookieDemo1.java)           
>    [获取上一次登录的时间](file:///G:\cache\idea\java\cookieandsession\src\main\java\com\CookieDemo3.java)


# session
> 会话, session是基于cookie的一种会话形式. Cookie是服务器返回一小份数据        
> 给客户端, 并且存放在客户端上, session是将数据存储在服务端. 

## 常用api
1. session.getId();
2. session.setAttribute();          
3. session.getAttribute(); 
4. session.removeAttribute();

## session的创建
* 如果在servlet中调用了request.getSession()就会创建
* session是存在服务器内存中的一份数据, 即使关了浏览器, 也不会销毁. >

## 销毁session
1.关闭服务器       
2.session的会话期过了. 默认30分钟.        
[购物车例子](file:///G:\cache\idea\java\cookieandsession\src\main\webapp\product_list.jsp)