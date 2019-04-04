package com.alpha.aop.jdk.enhancer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public interface AroundEnhancer extends Enhancer {
    Object around(Object o, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException;
}
