package com.alpha.aop.jdk.enhancer;

import java.lang.reflect.Method;

public interface AfterEnhancer extends Enhancer {
    void after(Object o, Method method, Object[] args, Object result);
}
