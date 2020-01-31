package com.springDemo3;

public class Employee2 {
    private String name;
    private Car2 car2;


    public Employee2(String name, Car2 car2) {
        this.name = name;
        this.car2 = car2;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", car2=" + car2 +
                '}';
    }
}
