package com.alpha.aop.advisor;

import com.alpha.aop.advice.BeforeRunning;
import com.alpha.aop.domain.Sedan;
import com.alpha.aop.domain.Truck;
import com.alpha.aop.domain.Vehicle;
import org.junit.Before;
import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AdvisorTest {
    private ProxyFactory proxyFactory;
    private ApplicationContext context;

    @Before
    public void setUp() throws Exception {
        proxyFactory = new ProxyFactory();
        proxyFactory.setProxyTargetClass(true);
        context = new ClassPathXmlApplicationContext("spring-config.xml");

    }

    @Test
    public void StaticAdvisorTest() throws Exception {
        StaticAdvisor staticAdvisor = new StaticAdvisor();
        BeforeRunning beforeRunning = new BeforeRunning();
        staticAdvisor.setAdvice(beforeRunning);
        proxyFactory.addAdvisor(staticAdvisor);

        Sedan sedan = new Sedan();
        proxyFactory.setTarget(sedan);
        Vehicle sedanProxy = (Vehicle) proxyFactory.getProxy();

        Truck truck = new Truck();
        Vehicle truckProxy = (Vehicle) proxyFactory.getProxy();


        sedanProxy.run();
        sedanProxy.maintain();
        truckProxy.run();
        truckProxy.maintain();
    }

    @Test
    public void staticAdvisoByXmlTest() {
        Sedan sedanProxy = context.getBean("sedan1", Sedan.class);
        Truck truckProxy = context.getBean("truck1", Truck.class);
        sedanProxy.run();
        sedanProxy.maintain();
        truckProxy.run();
        truckProxy.maintain();
    }

    @Test
    public void regexpAdvisorTest() {
        Sedan sedanProxy = context.getBean("sedan2", Sedan.class);
        Truck truckProxy = context.getBean("truck2", Truck.class);
        sedanProxy.run();
        sedanProxy.maintain();
        truckProxy.run();
        truckProxy.maintain();
    }

    @Test
    public void dynamicAdvisorTest() {
        Sedan sedanProxy = context.getBean("sedan3", Sedan.class);
        Truck truckProxy = context.getBean("truck3", Truck.class);
        sedanProxy.run("xian");
        sedanProxy.maintain();
        truckProxy.run("xian");
        truckProxy.maintain();
    }

    @Test
    public void controlFlowTest() {
        Sedan sedan = context.getBean("sedan4", Sedan.class);
        ControlFlowDemo controlFlowDemo = new ControlFlowDemo(sedan);
        sedan.run();
        controlFlowDemo.transport();
    }


}
