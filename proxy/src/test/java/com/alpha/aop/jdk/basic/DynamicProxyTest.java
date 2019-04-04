package com.alpha.aop.jdk.basic;


import com.alpha.aop.domain.Sedan;
import com.alpha.aop.domain.Vehicle;
import org.junit.Test;

import java.lang.reflect.Proxy;

public class DynamicProxyTest {

    @Test
    public void proxyTest() {
        Object o = Proxy.newProxyInstance(DynamicProxyTest.class.getClassLoader(),
                new Class[]{Vehicle.class}, new JdkDynamicProxy(new Sedan()));
        Vehicle vehicle = (Vehicle) o;
        vehicle.run();
    }

}
