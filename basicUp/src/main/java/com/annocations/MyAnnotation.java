package com.annocations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//自定义一个注解: 注解的作用: 配置

//在定义注解的时候, 通过元注解 Retention说明当前自定义注解的作用范围 :  (Class, Source, RunTime)
@Retention(RetentionPolicy.RUNTIME)

//通过元注解说明这个自定义注解的作用范围(变量/ 方法/ 包......)
@Target(ElementType.METHOD)
public @interface MyAnnotation {
    //注解定义属性,所有的属性修饰符都是public
    // 访问修饰符    类型  变量名称()  defalut 默认值
    public long timeout() default -1;
    public Class T() default java.util.Date.class;
}
