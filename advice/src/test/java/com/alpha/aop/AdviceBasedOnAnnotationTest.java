package com.alpha.aop;

import com.alpha.aop.advice.Navigable;
import com.alpha.aop.domain.Vehicle;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AdviceBasedOnAnnotationTest {
    private ApplicationContext context;

    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("spring-config.xml");
    }

    @Test
    public void beforeAdvice() {
        Vehicle seadanProxy = context.getBean("seadanProxy", Vehicle.class);
        seadanProxy.run();
    }

    @Test
    public void cglibProxyTest() {
        Vehicle cglibProxy = context.getBean("cglibProxy", Vehicle.class);
        cglibProxy.run();
    }

    @Test
    public void introduceAdviceTest() {
        Navigable navigableSeadan = context.getBean("navigableSeadan", Navigable.class);
        navigableSeadan.navigate();
    }


}
