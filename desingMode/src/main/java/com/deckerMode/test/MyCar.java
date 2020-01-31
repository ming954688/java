package com.deckerMode.test;

public class MyCar implements ICar{

    private ICar car = null;

    public MyCar(ICar car) {
        this.car = car;
    }

    @Override
    public void start() {
        car.start();
        System.out.println("检查天气");
    }

    @Override
    public void run() {
        car.run();
    }

    @Override
    public void stop() {
        car.stop();
    }
}
