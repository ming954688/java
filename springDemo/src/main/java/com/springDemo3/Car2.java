package com.springDemo3;

public class Car2 {
    private String name;
    private Integer price;

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Car2{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
