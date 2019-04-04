package com.alpha.aop.crosscutting.staticreform;

import com.alpha.aop.crosscutting.enhancer.BeforeEnhancer;
import com.alpha.aop.domain.Sedan;
import com.alpha.aop.domain.Vehicle;

public class SedanEnhanceByBefore extends Sedan implements Vehicle {
    private BeforeEnhancer beforeEnhancer;

    public SedanEnhanceByBefore(BeforeEnhancer beforeEnhancer) {
        this.beforeEnhancer = beforeEnhancer;
    }

    @Override
    public void run() {
        beforeEnhancer.before();
        super.run();
    }

    @Override
    public void run(String destination) {
        beforeEnhancer.before();
        super.run(destination);
    }

    @Override
    public Integer run(String departure, String destination) {
        beforeEnhancer.before();
        return super.run(departure, destination);
    }

    @Override
    public void failure() throws Throwable {
        super.failure();
    }

    @Override
    public void maintain() {
        super.maintain();
    }
}
