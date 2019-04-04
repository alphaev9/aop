package com.alpha.aop.schema;

import com.alpha.aop.domain.Sedan;
import com.alpha.aop.domain.Truck;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:afterThrow.xml")
public class AfterThrowTest {

    @Autowired
    private ApplicationContext context;

    @Test
    public void afterThrow() {

        Sedan sedan = context.getBean("sedan", Sedan.class);
        try {
            sedan.failure();
        } catch (Throwable throwable) {

        }


    }
}