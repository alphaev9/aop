package com.alpha.aop.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AroundRunning implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("i am ready for running");
        Object result = methodInvocation.proceed();
        System.out.println("tired,i need some rest");
        return result;
    }
}
