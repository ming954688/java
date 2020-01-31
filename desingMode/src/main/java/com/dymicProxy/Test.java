package com.dymicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {

        /* //获取GoogleCar.class字节码文件上的所有接口
        Class[] clazz = GoogleCar.class.getInterfaces();
        for (Class cla : clazz) {
            //获取接口上的所有方法
            Method[] methods = cla.getMethods();
            for (Method method : methods) {
                System.out.println(method.getName());
            }
        }*/

        //第一个参数, 固定值, 告诉虚拟机用哪个字节码加载器加载内存中创建出的字节码文件
        //第二个参数, 告诉虚拟机内存中正在被创建的字节码文件中应该有哪些方法
        //第三个参数, 告诉虚拟机正在被创建的字节码文件上的方法应该怎么处理
        ICar car = (ICar) Proxy.newProxyInstance(Test.class.getClassLoader(), GoogleCar.class.getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                //每个方法执行的返回值, 可能方法没有返回值,即为null
                Object object = null;

                //经过测试, method代表当前正在执行的每个方法
                //System.out.println(method.getName() + "------");
                //执行当前的方法
                if (method.getName().equals("start")) {
                    System.out.println("查看天气");
                    System.out.println("查看路况");
                }
                object = method.invoke(new GoogleCar(), args);
                return object;
            }
        });

        car.run();
        car.start();
        car.stop();


    }
}
