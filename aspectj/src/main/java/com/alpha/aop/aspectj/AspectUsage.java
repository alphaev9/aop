package com.alpha.aop.aspectj;

import com.alpha.aop.domain.EngineFailure;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AspectUsage {
    @Before("execution(void run())")
    public void beforeRun() {
        System.out.println("checking the health of the vehicle");
    }

    @AfterReturning(value = "execution(* run(..))", returning = "consumption")
    public void afterRun(Integer consumption) {
        System.out.println("assure the engine switched off");
        System.out.println("energy consumption is: " + consumption);
    }

    @AfterThrowing(value = "target(com.alpha.aop.domain.Sedan)", throwing = "failure")
    public void afterThrow(Exception failure) {
        System.out.println(failure.getMessage());
        System.out.println("be sure of parking at safety");
    }
}
