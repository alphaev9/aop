package com.alpha.aop.crosscutting;

import com.alpha.aop.crosscutting.enhancer.BeforeEnhancer;
import com.alpha.aop.crosscutting.staticreform.SedanEnhanceByBefore;
import org.junit.Before;
import org.junit.Test;

public class SedanEnhanceByBeforeTest {
    private SedanEnhanceByBefore sedanEnhanceByBefore;

    @Before
    public void setUp() throws Exception {
        sedanEnhanceByBefore = new SedanEnhanceByBefore(new BeforeEnhancer());
    }

    @Test
    public void run() {
        sedanEnhanceByBefore.run();
    }

    @Test
    public void run1() {
        sedanEnhanceByBefore.run("xian");
    }

    @Test
    public void run2() {
        sedanEnhanceByBefore.run("baoji", "xian");
    }
}