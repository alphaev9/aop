package com.alpha.aop.domain;

public class EngineFailure extends Exception {
    @Override
    public String getMessage() {
        return "engine failure occurred";
    }
}
