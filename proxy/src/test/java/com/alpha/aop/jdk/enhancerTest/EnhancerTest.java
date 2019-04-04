package com.alpha.aop.jdk.enhancerTest;

import com.alpha.aop.domain.Sedan;
import com.alpha.aop.domain.Vehicle;
import com.alpha.aop.jdk.enhancer.ProxyFactory;
import org.junit.Before;
import org.junit.Test;

public class EnhancerTest {
    private ProxyFactory proxyFactory;

    @Before
    public void setUp() {
        proxyFactory = new ProxyFactory();
        Sedan sedan = new Sedan();
        proxyFactory.setTarget(sedan);
        proxyFactory.setInterfaces(new Class[]{Vehicle.class});
    }

    @Test
    public void BeforeTest() {
        BeforeEnhancerImp beforeEnhancerImp = new BeforeEnhancerImp();
        proxyFactory.setEnhancer(beforeEnhancerImp);
        Vehicle proxy = (Vehicle) proxyFactory.getProxy();
        proxy.run();
    }

    @Test
    public void AfterTest() {
        AfterEnhancerImp afterEnhancerImp = new AfterEnhancerImp();
        proxyFactory.setEnhancer(afterEnhancerImp);
        Vehicle proxy = (Vehicle) proxyFactory.getProxy();
        proxy.run();
    }

    @Test
    public void AroundTest() {
        AroundEnhancerImp aroundEnhancerImp = new AroundEnhancerImp();
        proxyFactory.setEnhancer(aroundEnhancerImp);
        Vehicle proxy = (Vehicle) proxyFactory.getProxy();
        proxy.run();
    }
}
