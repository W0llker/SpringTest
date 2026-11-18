package org.example.notNeedClasses;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Component("car")
//@Scope(scopeName = "prototype")
//@Primary
public class Car implements Vehicle {
    public Car() {
        System.out.println("Car bean create");
    }

    @PostConstruct
    private void init() {
        System.out.println("Car init");
    }

    @Override
    public void startEngine() {
        System.out.println("Car started");
    }

    @PreDestroy
    private void destroy() {
        System.out.println("Car destroy");
    }
}
