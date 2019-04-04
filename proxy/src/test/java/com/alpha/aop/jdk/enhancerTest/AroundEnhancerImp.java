package com.alpha.aop.jdk.enhancerTest;

import com.alpha.aop.jdk.enhancer.AroundEnhancer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AroundEnhancerImp implements AroundEnhancer {
    @Override
    public Object around(Object o, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        System.out.println("test: before method called");
        Object result = method.invoke(o, args);
        System.out.println("test: after method called");
        return result;
    }
}
