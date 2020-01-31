> servlet就是一个java程序，运行在服务器上，用于接收和响应客户端的http请求   
> 更多是配合动态资源来使用,**静态资源也需要使用servlet**,
> 不过tomcat里面已经定义好了一个DefaultServlet.

# servlet生命周期
> 从创建到销毁的一段时间
1. 创建实例, 执行init方法. 第一次访问的时候会创建实例
2. 当有请求发生, 就会执行service方法
3. 当服务器关闭的时候, 会执行destroy方法
 
# 让servlet创建实例的时机提前
> 默认情况下,只有在初次访问servlet的时候回执行init方法, 有的时候要在这个方法中 
执行一些初始化工作
>> 这时候可能会要让初始化的时机提前

``` 
 <!--数字越小, 创建的时机越早-->
        <load-on-startup>1</load-on-startup>
```
# servletConfig 对象的作用 
1. 可以获取servlet的名字
2. 可以获取初始化的参数
3. 可以获取初始化参数的参数名枚举

[举例](file:///G:\cache\idea\java\servletDemo\src\main\java\ServletConfigDemo.java)


# servletContext对象
> servletContext 是servlet的上下文       
> 每一个web工程都只有一个servletContext对象, 就是不管在哪个serlvet里面,获取    
> 到的这个类的对象都是同一个

## 作用
1. 可以获取全局配置参数
2. 可以获取web应用中的资源
3. 存储数据, servlet之间共享数据. 域对象