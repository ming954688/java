package com.springAop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 切面类
 */
public class MyAspectXML {
    //用于测试前置通知
    public void beforeTest(JoinPoint joinPoint) {
        System.out.println("前置通知" + joinPoint);
    }

    //用于测试后置通知
    public void afterTest(JoinPoint joinPoint,Object result) {
        System.out.println("后置通知..." + joinPoint+result);
    }

    //用于测试环绕通知
    public Object aroundTest(ProceedingJoinPoint pj) throws Throwable {
        System.out.println("环绕前通知");
        //执行目标程序
        Object obj = pj.proceed();
        System.out.println("环绕后通知");
        return obj;
    }

    //用于测试异常抛出通知
    public void throwsTest(Throwable ex){
        System.out.println("程序出现异常了."+ex.toString());
    }

    //用于测试最终通知
    public void finallyTest(){
        System.out.println("最终通知...");
    }

}