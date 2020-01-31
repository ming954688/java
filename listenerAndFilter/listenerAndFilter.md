# Listener
> 监听器: 监听某一个事件的发生. 状态的改变        
* 内部机制: 接口回调

## 接口回调
需求: A在执行循环, 当循环到5的时候, 通知B
> 事先先把某一个对象传递给A, 当A执行到5的时候, 通过这个对象调用B的方法,但是不是直接传递B的实例, 而是传递一个接口的实例过去.       
[实例:](file:///G:\cache\idea\java\listenerAndFilter\src\main\java\com\callbackInterface)

## web监听器:
> 总共8个, 三中类型        
> 使用方法:         
1. 定义一个类,实现接口
2. 注册配置监听器
* 监听三个作用域创建和销毁      [Demo1](file:///G:\cache\idea\java\listenerAndFilter\src\main\java\com\ListenerDemo\Demo1)      
    request, session , application
    1. servletContextListener       
        *   利用它可以在servletContext创建的时候, 完成自己想要的初始化工作.
        *   执行自定义的任务调度.  
    2. servletRequestListener
    3. HttpSessionListener      
        *   统计在线人数
* 监听三个作用域属性状态变更     [Demo2](file:///G:\cache\idea\java\listenerAndFilter\src\main\java\com\ListenerDemo\Demo2)      
可以监听在作用域中添加 | 删除 | 替换的动作        

    1.  ServletContextAttributeListener
    2.  ServletRequestAttributeListener
    3.  HttpSessionAttributeListener
* 监听httpSession里面存值的状态变更          
这类监听器不需要注册      
    1. httpSessionBindingListener      [eg: ](file:///G:\cache\idea\java\listenerAndFilter\src\main\java\com\ListenerDemo\Demo3\httpSessionBindingListener)        
        * 对象与session绑定的动作 
        * 让javabean 实现该接口即可
    2. HttpSessionActivationListener   [eg:](file:///G:\cache\idea\java\listenerAndFilter\src\main\java\com\ListenerDemo\Demo3\HttpSessionActivationListener)     
        * 用于监听现在session的值是钝化(序列化)还是活化(反序列化)的动作
        * 把内存中的数据存储到硬盘上(序列化)
        * 把硬盘上的数据读取到内存(反序列化)
         
    > session中的值可能会很多, 并且我们有很长一段时间不使用这个内存中的值, 那么可以考虑吧sessioin中的值存储到硬盘上,         
    等下一次在使用的时候 , 再从硬盘上提取出来. 
    
        * 配置session在一定时间后, 自动序列化   
        1. 在tomcat里面的conf/context.xml里面配置 
        2. 在tomcat里面的conf/Catalina/localhost/context.xml配置  
        3. 在自己工程中的META-INF/context.xml中配置
        
        
# Filter
> 过滤器 其实就是对客户端发出来的请求进行过滤, 过滤器起到的是拦截的作用
* 过滤敏感词汇
* 统一设置编码
* 自动登录
 
## 如何使用过滤器:
1. 定义一个类实现filter接口
2. 注册过滤器, 在web.xml中

## filter的生命周期
1. 在服务器启动的时候, 创建filter
2. 服务器停止的时候, filter销毁

## 执行顺序
如果有多个过滤器, 会按照注册的映射顺序来排队, 只要有一个过滤器不放行, 那么后面排队的过滤器        
以及servlet都不会收到请求.

### 细节

```
<url-pattern>/*</url-pattern>

1. 全路径匹配 以  /  开始       
eg: /Demo1Servlet
2. 以目录匹配 以  /   开始 , 以  *  结束       
eg: /filter/*
3. 以后缀名匹配 以 * 开始, 以后缀名结束
eg: *.jsp, *.do, *.html
4. 针对dispatcher: 
    1. REQUEST: 只要是请求, 都拦截. 默认是REQUEST
    2. FORWARD: 只要是转发, 都拦截  
    3. ERROR:   页面出错, 发生跳转的时候拦截
    4. INCLUD:  包含页面的时候拦截
```

[案例: 自动登录](file:///G:\cache\idea\java\listenerAndFilter\src\main\java\com\FilterDemo\autoLogin)

