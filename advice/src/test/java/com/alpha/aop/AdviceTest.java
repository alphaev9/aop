package com.alpha.aop;

import com.alpha.aop.advice.*;
import com.alpha.aop.domain.Sedan;
import com.alpha.aop.domain.Vehicle;
import org.junit.Before;
import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;


public class AdviceTest {
    private ProxyFactory proxyFactory;

    @Before
    public void setUp() {
        Sedan sedan = new Sedan();
        proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(sedan);
    }

    @Test
    public void beforeTest() {
        BeforeRunning beforeRunning = new BeforeRunning();
        proxyFactory.addAdvice(beforeRunning);
        Vehicle vehicle = (Vehicle) proxyFactory.getProxy();
        vehicle.run();
    }

    @Test
    public void afterTest() {
        AfterRunning afterRunning = new AfterRunning();
        proxyFactory.addAdvice(afterRunning);
        Vehicle vehicle = (Vehicle) proxyFactory.getProxy();
        vehicle.run();
    }

    @Test
    public void aroundTest() {
        AroundRunning aroundRunning = new AroundRunning();
        proxyFactory.addAdvice(aroundRunning);
        Vehicle vehicle = (Vehicle) proxyFactory.getProxy();
        vehicle.run();
    }

    @Test
    public void failureTest() {
        EngineFailure engineFailure = new EngineFailure();
        proxyFactory.addAdvice(engineFailure);
        Vehicle vehicle = (Vehicle) proxyFactory.getProxy();
        vehicle.run();

        try {
            vehicle.failure();
        } catch (Throwable throwable) {
            System.out.println(throwable.getMessage());
        }

    }

    @Test
    public void introduceTest() {
        IntroduceAdvice introduceAdvice = new IntroduceAdvice();
        proxyFactory.setInterfaces(Navigable.class);
        proxyFactory.setProxyTargetClass(true);
        proxyFactory.addAdvice(introduceAdvice);
        Vehicle vehicle = (Vehicle) proxyFactory.getProxy();
        vehicle.run();
        Navigable navigableVehical = (Navigable) vehicle;
        navigableVehical.navigate();
    }

    @Test
    public void mutipleAdviceTest() {
        BeforeRunning beforeRunning = new BeforeRunning();
        AfterRunning afterRunning = new AfterRunning();
        AroundRunning aroundRunning = new AroundRunning();
        proxyFactory.addAdvice(beforeRunning);
        proxyFactory.addAdvice(afterRunning);
        proxyFactory.addAdvice(2, aroundRunning);
        Vehicle vehicle = (Vehicle) proxyFactory.getProxy();
        vehicle.run();
    }
}
