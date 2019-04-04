package com.alpha.aop.domain;

public interface Vehicle {

    void run();

    void run(String destination);

    Integer run(String departure, String destination);

    void failure() throws Throwable;

    void maintain();
}
