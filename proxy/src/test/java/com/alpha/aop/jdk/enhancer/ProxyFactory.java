package com.alpha.aop.jdk.enhancer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {
    private Object target;
    private Enhancer enhancer;
    private Class[] interfaces;

    public void setTarget(Object target) {
        this.target = target;
    }

    public void setEnhancer(Enhancer enhancer) {
        this.enhancer = enhancer;
    }

    public void setInterfaces(Class[] interfaces) {
        this.interfaces = interfaces;
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(ProxyFactory.class.getClassLoader()
                , interfaces, new JdkProxy());
    }

    class JdkProxy implements InvocationHandler {
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (enhancer instanceof BeforeEnhancer) {
                ((BeforeEnhancer) enhancer).before(target, method, args);
                return method.invoke(target, args);
            } else if (enhancer instanceof AfterEnhancer) {
                Object result = method.invoke(target, args);
                ((AfterEnhancer) enhancer).after(target, method, args, result);
                return result;
            } else {
                return ((AroundEnhancer) enhancer).around(target, method, args);
            }
        }
    }
}
