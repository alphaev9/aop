package com.alpha.aop.domain;

public class Sedan implements Vehicle {
    @Override
    public void run() {
        System.out.println("the car is running...");
    }

    @Override
    public void run(String destination) {
        System.out.println("the car is going to " + destination);
    }

    @Override
    public Integer run(String departure, String destination) {
        System.out.println("the car is running from " + departure + " to " + destination);
        return 100;
    }

    @Override
    public void failure() throws Throwable {
        throw new EngineFailure();
    }

    @Override
    public void maintain() {
        System.out.println("it's time of maintaining car");
    }
}
