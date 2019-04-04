package com.alpha.aop.jdk.enhancer;

import java.lang.reflect.Method;

public interface BeforeEnhancer extends Enhancer {
    void before(Object o, Method method, Object[] args);
}
