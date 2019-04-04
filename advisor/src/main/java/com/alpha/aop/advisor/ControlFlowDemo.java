package com.alpha.aop.advisor;

import com.alpha.aop.domain.Vehicle;

public class ControlFlowDemo {
    public ControlFlowDemo(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    private Vehicle vehicle;

    public void transport() {
        vehicle.run();
        vehicle.maintain();
    }
}
