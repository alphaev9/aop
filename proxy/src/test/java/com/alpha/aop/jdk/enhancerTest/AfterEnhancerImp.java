package com.alpha.aop.jdk.enhancerTest;

import com.alpha.aop.jdk.enhancer.AfterEnhancer;

import java.lang.reflect.Method;

public class AfterEnhancerImp implements AfterEnhancer {
    @Override
    public void after(Object o, Method method, Object[] args, Object result) {
        System.out.println("test: after enhancer");
    }
}
