package org.example.notNeedClasses;

import org.springframework.stereotype.Component;

//@Component("bike")
public class Motorbike implements Vehicle {
    public Motorbike() {
        System.out.println("Motorbike bean create");
    }
    @Override
    public void startEngine() {
        System.out.println("Motorbike started");
    }
}
