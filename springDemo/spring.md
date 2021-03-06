# spring

## 什么是spring

javaee 开发的一站式框架
> 有ee开发的每一层解决方案  
    * web层： springmvc  
    * service层: spring的bean管理, spring声明式事务  
    * dao层: spring的jdbc模板,  spirng的orm模块

# spring的ioc入门

## 什么是ioc

> 控制反转:
    将对象创建的权利交给spring
    
    
## springioc底层实现

工厂 + 反射 + 配置文件

* 将实现类交给spring管理  

  [bean配置]:src/main/resources/applicationContext.xml

  



## DI(依赖注入)

> 前提: 有IOC的环境, spring 在管理这个类的时候,会将依赖的属性注入进来  
[依赖注入; ](file:///G:\cache\idea\java\springDemo\src\main\java\com\springDemo1\UserDaoImpl.java)

## spring的工厂类:

* BeanFactory: 老版本的工厂类 调用getBean()方法的时候, 生成类的实例
* ApplicationContext: 新版本的工厂类  (继承了BeanFactory) 在加载配置文件的时候将spring管理的类实例化  
有两个实现类:  
        1. ClassPathApplicationContext : 加载类路径下的配置文件  
              2. FileSystemXmlApplicationContext: 加载文件系统下的配置文件

## spring的配置项 IOC

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
[配置文件](file:///G:\cache\idea\java\springDemo\src\main\resources\applicationContext1.xml)

#### 1. p名称空间的属性注入(spring2.5之后的版本可以使用)

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

#### 2. spel的属性注入: (spring3.0之后的版本可以使用)

参考spel语法

#### 3. 注入集合类型的属性

[配置文件: ](file:///G:\cache\idea\java\springDemo\src\main\resources\applicationContext2.xml)

## springIoc的注解开发

1. 引入context约束文件
2. 在spring的配置文件中配置扫描
3. 在相关的类中添加注解  
[实例: ](file:///G:\cache\idea\java\springDemo\src\main\java\com\springIocAnnocation\UserDaoImpl.java)
```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context" xsi:schemaLocation="
        http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd"> <!-- bean definitions here -->
<!--spring的IOC的注解入门-->
<!--使用IOC的注解开发 , 配置扫描-->
    <context:component-scan base-package="com.springIocAnnocation">
    </context:component-scan>
</beans>
```

### 注解方式设置属性的值
注解方式设置属性的值, 可以没有set方法  
属性如果有set方法, 将属性注入的注解添加到set方法上.  
属性如果没有set方法, 将属性注入的注解添加到属性上即可.

### spring的ioc的注解详解
#### 1. Component:(组件)
> 修饰一个类, 将这个类交给spring管理  
> 这个注解有三个衍生注解(功能类似)

* Controller: web层
* Service: 业务层
* Repository: Dao层

#### 2. 属性注入的注解

* 普通属性的注解:
  
    * @value: 设置普通属性的值
* 对象类型属性的注解:  
@Autowired: 设置对象类型属性的值, 但是是按照类型完成属性注入  
    我们习惯使用名称(id) 进行属性的注入, 所以使用另一个注解结合使用@Qualifier  
    [Qualifier:](file:///G:\cache\idea\java\springDemo\src\main\java\com\springIocAnnocation\UserServiceImpl.java)

    可以使用 @Resource注解代替上面的两个注解  
    完成对象类型的属性的注入, 按照名称完成属性的注入

#### 3. Bean的其他注解

* 配置生命周期  
[例子: ](file:///G:\cache\idea\java\springDemo\src\main\java\com\springIocAnnocation\otherAnnocation\CustomerService.java)

* Bean的作用范围的注解
@Scope: 作用范围, 用法同xml配置方式  
[例子: ](file:///G:\cache\idea\java\springDemo\src\main\java\com\springIocAnnocation\otherAnnocation\CustomerService.java)

## springIoc的注解方式和xml方式比较
适用场景:
* xml: 可以适用任何场景
    * 结构清晰, 维护方便

* 注解: 有些地方不可以适用, 比如这个类不是自己提供的.
    * 开发方便

### xml和注解整合开发:
> xml管理bean, 注解完成属性注入  
[实例: ](file:///G:\cache\idea\java\springDemo\src\main\java\com\springIocXmlAndAnnocation\ProductService.java)



# springAop

> AOP: 面向切面编程 , 是OOP的扩展和延伸, 解决OOP开发中遇到的问题
spring底层的aop实现原理:
* 动态代理:
    1. JDK动态代理: 只能对实现了接口的类产生代理  
    [实例: ](file:///G:\cache\idea\java\desingMode\src\main\java\com\dymicProxy\jdkProxy\UserDaoProxy.java)
    2. Cglib动态代理: 第三方代理技术, 对没有实现接口的类产生代理对象. 生成子类对象. 动态的添加类的属性和方法
    [Cglib实例:](file:///G:\cache\idea\java\desingMode\src\main\java\com\dymicProxy\cglibProxy\CglibProxy.java)

## spring的aop开发 (AspectJ的xml配置方式)

spring中有两套aop的开发方式
* spring传统模式(弃用)
* spring基于AspectJ的aop开发(使用)

## aop开发中的相关术语

1. joinpoint: 连接点, 可以被拦截的点, 可以被增强的方法
2. pointcut: 切入点, 真正被拦截的点. 真正被增强的方法
3. advice: 通知/增强 对方法增强的部分 (方法层面的增强)
4. introduction: 引介 . (类层面的增强)
5. target: 目标  被增强的对象. 即为切入点所在的类.
6. Weaving: 织入 ---> 将通知(advice)  应用到目标(target) 的过程
7. Proxy: 代理对象
8. Aspect: 切面, 多个通知和多个切入点的组合


> 1. 需要额外引入两个jar包, aop联盟.jar, aspectjweaver.jar
> 2. 编写切面类, 交给spring管理, 里面封装增强的方法  
      [eg: ](file:///G:\cache\idea\java\springDemo\src\main\java\com\springAop\MyAspectXML.java)
> 3. 配置aop生成代理对象  
      [eg: ](file:///G:\cache\idea\java\springDemo\src\main\resources\applicationContext_aop.xml)

### spring中的通知类型:

1. 前置通知: 在目标方法执行之前进行操作 ---> 获取切入点的信息
```
<aop:before method="checkPri" pointcut-ref="pointcut"/>
```
2. 后置通知: 在目标方法执行之后进行操作 ---> 获取方法的返回值
```
配置文件中的returning写的参数名 需要和 增强方法中的参数名一致
 <aop:after-returning method="afterTest" pointcut-ref="pointcut1" returning="result"/>
```
3. 环绕通知: 在目标方法执行之前后之后进行操作 ----> 可以阻止目标方法的执行
```
切面类中增强的方法需要添加参数, 并且有返回值.
<aop:around method="aroundTest" pointcut-ref="pointcut2"/>
```
4. 异常抛出通知: 在程序出现异常的时候, 进行的操作
```
throwing写的参数名 需要和 切面类中的Throwable参数的 参数名一致
<aop:after-throwing method="throwsTest" pointcut-ref="pointcut3" throwing="ex"/>
```
5. 最终通知: 无论代码是否有异常, 总是会执行.
6. 引介通知(不需要管)

### spring 切入点表达式的写法

> 基于execution的函数完成的.  
> 语法: [访问修饰符] 方法的返回值 包名.类名.方法名(参数)

### spring的AOP的基于AspectJ的注解开发

1. 引入jar包
2. 引入配置文件
3. 将目标类, 切面类交给spring管理
4. 使用注解对目标类进行增强
    * 在配置文件中打开aop注解配置
    * 在切面类上使用注解  
[实例: ](file:///G:\cache\idea\java\springDemo\src\main\java\com\springAop\annocationAop\MyAspectAnno.java)

> aop的相关注解:
```
@Aspect : 定义切面类的注解

通知类型: 
@Before: 前置通知
@AfterReturing: 后置通知
@AfterThrowing: 异常抛出通知
@Around: 环绕通知
@After: 最终通知

定义切入点: 
@PointCut
```



# spring中的事务管理



## springjdbc模板的使用, 整合c3po连接池

[实例: ](file:///G:\cache\idea\java\springDemo\src\main\java\com\springJdbc\User.java)  
[配置文件: ](file:///G:\cache\idea\java\springDemo\src\main\resources\applicationContext_C3P0.xml)





## spring中的传播行为

> 用途: 用于解决复杂的业务层方法相互调用的问题  
> 7种, 三类
1. 保证多个操作在同一个事务中
    * PROPAGATION_REQUIRED ****** 默认值: 如果A中有事务, 就直接使用A中的事务,如果本身没有事务, 会自动创建一个新的事务, 将所有的操作包含在一起
    * PROPAGATION_SUPPORTS: 支持事务, 如果A中有事务, 使用A中的事务. 如果没有事务, 就不使用事务
    * PROPAGATION_MANDATORY: 如果A中有事务, 使用A中的事务, 如果没有事务, 直接抛出异常.
2. 保证多个操作不在同一个事务中
    * PROPAGATION_REQUIRED_NEW:  ****** 如果A中有事务, 挂起A中的事务. 之后创建新的事务, 只包含自身的操作. 如果A中没有事务, 也会创建一个新的事务, 包含自己自身的操作
    * PROPAGATION_NOT_SUPPORTED: 如果A中有事务, 挂起A中的事务. 不使用事务
    * PROPAGATION_NEVER: 如果A中有事务, 直接抛出异常
3. 嵌套式事务
    * PROPAGATION_NESTED ******: 嵌套事务, 如果A中有事务, 按照A的事务执行, 执行完成后. 设置一个保存点, 执行B中的操作. 如果没有异常,执行通过, 如果有异常, 可以选择回滚到最初的位置, 也可以回滚到保存点  
  <img src="./Snipaste_2020-02-10_02-21-23.png">



​				

## spring管理事务的方式

1. 编程式事务
    1. 配置平台事务管理器
    2. 配置事务管理的模板
    3. 在需要用到事务的地方(业务层) 注入事务管理的模板  
[实例: ](file:///G:\cache\idea\java\springDemo\src\main\java\com\springTx\AccountServiceImpl.java)
2. 声明式事务(通过配置实现, 底层AOP)
    * XML式的事务管理
        1. 配置文件中配置平台事务管理器
        2. 配置事务的增强(相当于是aop中的切面类)
        3. 配置aop, 将事务的增强应用到被增强的方法中  
        [实例: ](file:///G:\cache\idea\java\springDemo\src\main\resources\applicationContext_txwithXML.xml)
    * 注解式的事务管理
        1. 配置文件中配置平台事务管理器
        2. 开启注解事务
        3. 在业务层上添加事务注解  
        [实例: ](file:///G:\cache\idea\java\springDemo\src\main\resources\applicationContext_txwithAnno.xml)









# spring分模块开发

1. 在加载配置文件的时候, 加载多个.

```
ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml","applicationContext1.xml");
```

2. 在一个配置文件中, 引入多个配置文件

```
<import resource="applicationContext1.xml"></import>
```





# spring整合单元测试

```
在测试类上加上如下注解即可

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext_aop.xml")
```

##