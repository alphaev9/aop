package com.alpha.aop.advisor;

import com.alpha.aop.domain.Sedan;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;

import java.lang.reflect.Method;

public class StaticAdvisor extends StaticMethodMatcherPointcutAdvisor {
    @Override
    public boolean matches(Method method, Class<?> aClass) {
//        System.out.println("method matching is working...");
        return "run".equals(method.getName());
    }

    /**
     * optimize: using class filter mechanism
     */

    @Override
    public ClassFilter getClassFilter() {
//        System.out.println("class filter is the first gate");
        return new ClassFilter() {
            @Override
            public boolean matches(Class<?> aClass) {
                return Sedan.class.isAssignableFrom(aClass);
            }
        };
    }
}
