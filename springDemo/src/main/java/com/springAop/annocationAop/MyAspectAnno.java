package com.springAop.annocationAop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

//注解方式 切面类
@Aspect
public class MyAspectAnno {
    //切入点注解:
    @Pointcut(value = "execution(* com.springAop.annocationAop.OrderDao.save(..))")
    private void pointcut1(){}

    @Pointcut(value = "execution(* com.springAop.annocationAop.OrderDao.update(..))")
    private void pointcut2(){}

    @Pointcut(value = "execution(* com.springAop.annocationAop.OrderDao.delete(..))")
    private void pointcut3(){}

    @Pointcut(value = "execution(* com.springAop.annocationAop.OrderDao.find(..))")
    private void pointcut4(){}


    //前置增强
    @Before(value = "MyAspectAnno.pointcut1()")
    public void before(){
        System.out.println("前置增强....aopAnno");
    }

    //后置增强
    @AfterReturning(value = "MyAspectAnno.pointcut2()",returning = "result")
    public void afterReturing(Object result){
        System.out.println("后置增强...aopAnno"+"返回值为=="+result);
    }

    //环绕增强
    @Around(value = "MyAspectAnno.pointcut3()")
    public Object around(ProceedingJoinPoint pj) throws Throwable {
        System.out.println("环绕前增强");
        String proceed = (String) pj.proceed();
        System.out.println(proceed);
        System.out.println("环绕后 增强..");
        return proceed;
    }

    //异常抛出通知
    @AfterThrowing(value = "MyAspectAnno.pointcut4()",throwing = "ex")
    public void afterThrowing(Throwable ex){
        System.out.println("异常抛出通知"+"==="+ex.toString());
    }

    //最终通知
    @After(value = "execution(* com.springAop.annocationAop.OrderDao.update(..))")
    public void after(){
        System.out.println("最终通知");
    }



}
