package com.alpha.aop.autoproxy;

import com.alpha.aop.domain.Sedan;
import com.alpha.aop.domain.Truck;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config.xml")
@ActiveProfiles({"autoScan"})
public class autoproxyTest {
    @Autowired
    private ApplicationContext context;

    @Test
    public void autoproxyTest() {
        Sedan sedan = context.getBean("vehicle_sedan", Sedan.class);
        Truck truck = context.getBean("vehicle_truck", Truck.class);
        sedan.run();
        truck.run();
    }

}
