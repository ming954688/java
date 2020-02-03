package com.springAop;

public class ProductDaoImpl implements ProductDao {
    @Override
    public void save() {
        System.out.println("保存...");
    }

    @Override
    public String find() {
        System.out.println("查询...");
        return "返回值测试";
    }

    @Override
    public void update() {
        System.out.println("更新...");
    }

    @Override
    public void delete() {
        System.out.println("删除...");
        int i = 1/0;

    }
}
