# spring
## 什么是spring
javaee 开发的一站式框架
> 有ee开发的每一层解决方案  
    * web层： springmvc  
    * service层: spring的bean管理, spring声明式事务  
    * dao层: spring的jdbc模板,  spirng的orm模块

## spring的ioc入门
### 什么是ioc
> 控制反转:
    将对象创建的权利交给spring
#### springioc底层实现
工厂 + 反射 + 配置文件

* 将实现类交给spring管理  
[bean配置](file:///G:\cache\idea\java\springDemo\src\main\resources\applicationContext.xml)

### DI(依赖注入)
> 前提: 有IOC的环境, spring 在管理这个类的时候,会将依赖的属性注入进来  
[依赖注入; ](file:///G:\cache\idea\java\springDemo\src\main\java\com\springDemo1\UserDaoImpl.java)

## spring的工厂类:
* BeanFactory: 老版本的工厂类 调用getBean()方法的时候, 生成类的实例
* ApplicationContext: 新版本的工厂类  (继承了BeanFactory) 在加载配置文件的时候将spring管理的类实例化  
有两个实现类:  
        1. ClassPathApplicationContext : 加载类路径下的配置文件  
        2. FileSystemXmlApplicationContext: 加载文件系统下的配置文件

## spring的配置项
### 1. Bean标签的相关配置
```
 <bean id="userService" name="" class="com.springDemo1.UserServiceImpl">
 </bean>
 
 id: 使用了唯一的约束, 不能出现特殊字符 
 name: 没有使用唯一约束. 开发中不允许name相同. 可以出现特殊字符
 id , name 效果相同
 class: 类的全限定名
 Bean的生命周期的配置: init-method(初始化的时候执行的方法), destory-method(bean被销毁时候执行的方法 bean是单例创建的, 工厂关闭)
 
 
 bean的作用范围的配置: 
 <bean id="CustomerDao" class="com.springDemo2.CustomerDaoImpl" scope="singleton">
 </bean>
 ** 1. singleton: 默认的, spirng采用单例模式创建这个对象
 ** 2. prototype: 多例模式, 用一次就创建一个新的对象
 3. request: 应用在web项目中, spring创建这个类后, 会将这个类存入到request域中.
 4. session: 应用在web项目中, spring创建这个类后, 会将这个类存入到session域中.
 5. globalsession: 应用在web项目中, 必须在porlet环境下使用(单点登录系统) 如果没有这种环境, 相当于是session
```

### 2. spring的属性注入
> spring给bean中的属性设置值的方式有2种
1. 构造方法方式
2. set方法方式  
详细见spring的配置文件

#### p名称空间的属性注入(spring2.5之后的版本可以使用)
写法:  
普通属性:   p:属性名 = "   "  
对象类型的属性: p: 属性名-ref= "  "  
eg:
```
首先复制一行: 
 xmlns:p="http://www.springframework.org/schema/p"

<!--car2 p名称空间的方式注入-->
    <bean id="car2p" class="com.springDemo3.Car2" p:name="奇瑞" p:price="5000">
    </bean>
    
    <!--p名称空间注入对象类型的属性, employee2-->
    <bean id="employeep" class="com.springDemo3.Employee" p:name="校长" p:car2-ref="car2">
    </bean>
```
