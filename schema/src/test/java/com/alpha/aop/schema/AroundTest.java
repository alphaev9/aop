package com.alpha.aop.schema;

import com.alpha.aop.domain.Sedan;
import com.alpha.aop.domain.Truck;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:aroundRun.xml")
public class AroundTest {
    @Autowired
    private ApplicationContext context;

    @Test
    public void aroundRun() {
        Sedan sedan = context.getBean("sedan", Sedan.class);
        Truck truck = context.getBean("truck", Truck.class);
        sedan.run("baoji", "xian");
        truck.run("xian", "baoji");
    }

}