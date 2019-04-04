package com.alpha.aop.jdk.enhancerTest;

import com.alpha.aop.jdk.enhancer.BeforeEnhancer;

import java.lang.reflect.Method;

public class BeforeEnhancerImp implements BeforeEnhancer {
    @Override
    public void before(Object o, Method method, Object[] args) {
        System.out.println("test: before enhancer");
    }
}
