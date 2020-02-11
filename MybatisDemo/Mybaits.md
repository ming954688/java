# Mybatis

*Mybatis架构图:* 

<img src="./Mybatis架构.png">

## 入门程序
1. 创建mybaits核心配置文件, sqlmapperconfig.xml文件   [eg: ](file:///G:\cache\idea\java\MybatisDemo\src\main\resources\SqlMapperConfig.xml)
2. 创建pojo对应的mapper.xml文件    [eg: ](file:///G:\cache\idea\java\MybatisDemo\src\main\resources\sqlMapper\User.xml)
3. 编写mapper.xml中的sql语句
4. 测试代码 [eg: ](file:///G:\cache\idea\java\MybatisDemo\src\test\java\com\mybatisDemo\Demo1Test.java)

## mybatis中的占位符写法:

* #{} 表示占位符 自带单引号, 里面的值可以随便写
* ${} 表示字符串拼接 不带单引号 里面的值只能写value

## mybatis和hibernate的不同

* mybatis不是一个完全的ORM框架, 需要自己手动编写sql语句, hibernate是一个完全的ORM框架, 自动生成sql语句.
* mybatis灵活, 可以严格的控制sql的执行. hibernate比较困难做到.
* mybatis不能做到数据库无关性, 如果切换数据库, 需要手动定义多套sql映射文件. 工作量大. hibernate切换数据库方便



## mapper动态代理开发

遵循四个原则: 

	1. 接口的方法名 == mapper.xml文件中的id名称
 	2. 返回值类型 == mapper.xml文件中的返回值类型
 	3. 方法的入参类型 == mapper.xml文件中的入参的类型
 	4. 命名空间和接口绑定

<img src="./1.png"  />





## SqlMapperConfig.xml配置内容

​	**以下的标签顺序不可以改变, 否则会报错**

1. properties(属性) 

   ​	读取配置文件

2.  typeAliases(别名)

     - typeAlias

   ​	如果配置了别名, 那么在mapper.xml中可以不写完整的类路径, 直接使用起的别名即可, 如果有很多的pojo类, 每一个都要编写一个

   <img src = "./2.png"	/>

   

   * package

     如果使用package, 只需要指定父包即可, 会自动扫描下面的子包. 别名就是pojo类的类名

3.  mapper

   ​	除了resource 标签, 还有一个package标签常用. 

   ```xml
   <package name="com.mybatisDemo.mapper"/>
   使用这种方式, 要求mapper接口的名称和mapper.xml文件名称一致, 而且放在同一个包下.
   ```

   

   

