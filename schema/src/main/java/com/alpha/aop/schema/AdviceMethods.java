package com.alpha.aop.schema;

import org.aspectj.lang.ProceedingJoinPoint;

public class AdviceMethods {
    public void beforeRun() {
        System.out.println("checking the health of the vehicle");
    }

    public void afterRun(Integer consumption) {
        System.out.println("assure the engine switched off");
        System.out.println("energy consumption is: " + consumption);
    }

    public void afterThrow(Exception failure) {
        System.out.println(failure.getMessage());
        System.out.println("be sure of parking at safety");
    }

    public void around(ProceedingJoinPoint joinPoint, String departure, String destination) throws Throwable {
        System.out.println("the journey: " + departure + "------" + destination);
        Object result = joinPoint.proceed();
        System.out.println("the energy consumption: " + result);
    }
}
