package com.alpha.aop.crosscutting.dynamicreform;

public class PointCut {
    private String methodName;
    private PointCutType type;

    public PointCut(String methodName, PointCutType type) {
        this.methodName = methodName;
        this.type = type;
    }

    public String getMethodName() {
        return methodName;
    }

    public PointCutType getType() {
        return type;
    }
}
