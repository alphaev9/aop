package com.alpha.aop.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class JointPointUsage {
    @Around("execution(Integer run(..))")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        String departure = (String) joinPoint.getArgs()[0];
        String destination = (String) joinPoint.getArgs()[1];
        System.out.println("the journey: " + departure + "------" + destination);
        Object result = joinPoint.proceed();
        System.out.println("the energy consumption: " + result);
    }
}
