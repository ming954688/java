package com.annocations;

public class UerDao {
    static {
        System.out.println("被加载了.....");
    }


    @MyAnnotation
    public void add(){
        System.out.println("添加...");
    }

    public void delete(){
        System.out.println("删除");
    }

    public void change(){
        System.out.println("修改");
    }

    public void find(){
        System.out.println("查询.");
    }
}
