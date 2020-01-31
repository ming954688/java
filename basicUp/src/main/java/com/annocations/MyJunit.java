package com.annocations;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyJunit {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, InstantiationException {
        //1. 将字节码文件 加载到内存中.
        Class clazz = Class.forName("com.annocations.UerDao");
        //2. 获取字节码对象上的所有方法
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            //3. 判断当前的方法上有没有@MyJunit这个注解, 如果有, 执行. 没有的话. 不执行
            if(method.isAnnotationPresent(MyAnnotation.class)){
                method.invoke(clazz.newInstance());
            }
        }
        

    }
}
