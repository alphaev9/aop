package com.alpha.aop.advice;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

public class IntroduceAdvice extends DelegatingIntroductionInterceptor implements Navigable {
    @Override
    public void navigate() {
        System.out.println("ha,though i am a car,but i can navigate");
    }

    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        return super.invoke(mi);
    }
}
