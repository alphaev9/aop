package com.alpha.aop.aspectj;

import com.alpha.aop.domain.Sedan;
import org.junit.Before;
import org.junit.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

public class AspectUsageTest {
    private AspectJProxyFactory aspectJProxyFactory;

    @Before
    public void setUp() throws Exception {
        aspectJProxyFactory = new AspectJProxyFactory();
    }

    @Test
    public void aspectTest(){
        Sedan sedan = new Sedan();
        aspectJProxyFactory.setTarget(sedan);
        /**there,the order is important,before adding aspect,the target must be set*/
        aspectJProxyFactory.addAspect(AspectUsage.class);
        Sedan proxy = aspectJProxyFactory.getProxy();
        proxy.run();
        proxy.run("baoji", "xian");
        try {
            proxy.failure();
        } catch (Throwable throwable) {

        }
    }
}