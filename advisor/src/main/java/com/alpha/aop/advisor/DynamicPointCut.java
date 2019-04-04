package com.alpha.aop.advisor;

import com.alpha.aop.domain.Truck;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import java.lang.reflect.Method;

public class DynamicPointCut extends DynamicMethodMatcherPointcut {
    /**
     * notice: the arguments information is included in the match method parameter list
     * so using these info,the matching  decision can be made not only by the method static info,but also relying on runtime info
     */
    @Override
    public boolean matches(Method method, Class<?> aClass, Object... objects) {
        return "xian".equals(objects[0]);
    }

    /**
     * optimize: dynamic matching occurs while method is called,which can introduce performance drop
     * you can use some optimizing trick,presenting in following code.
     * the key point of optimizing is fully exploiting static info to avoid unnecessary method matching at runtime.
     * when you provide static pointcut condition,initial matching will occur at proxy creation time and so filter out
     * unqualified candidate.
     */

    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        return targetClass.isAssignableFrom(Truck.class) && "run".equals(method.getName());
    }

}
