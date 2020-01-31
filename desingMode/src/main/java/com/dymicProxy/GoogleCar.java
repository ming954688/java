package com.dymicProxy;

public final class GoogleCar implements ICar {
    @Override
    public void start() {
        System.out.println("Google汽车启动了....");
    }

    @Override
    public void run() {
        System.out.println("Google汽车开起来了...");
    }

    @Override
    public void stop() {
        System.out.println("Google汽车停止了...");
    }

}
