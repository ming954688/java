package com.deckerMode.test;

public class Test {
    public static void main(String[] args) {
        ICar car = new MyCar(new GoogleCar());
        car.start();
        car.stop();
    }
}
