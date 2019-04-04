package com.alpha.aop.aspectj;

import com.alpha.aop.domain.Sedan;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class JointPointUsageTest {
    @Autowired
    private ApplicationContext context;

    @Test
    public void jointPointTest() {
        Sedan sedan = context.getBean("sedan", Sedan.class);
        sedan.run();
        sedan.run("baoji", "xian");
    }
}