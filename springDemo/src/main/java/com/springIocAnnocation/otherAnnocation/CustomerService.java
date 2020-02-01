package com.springIocAnnocation.otherAnnocation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
@Scope(value = "prototype")
public class CustomerService {
    //spring配置初始化方法
    @PostConstruct
    public void init() {
        System.out.println("初始化了....");
    }

    public void save() {
        System.out.println("service的save方式执行......");
    }

    //spring配置销毁的方法
    @PreDestroy
    public void destory() {
        System.out.println("销毁了....");
    }
}
