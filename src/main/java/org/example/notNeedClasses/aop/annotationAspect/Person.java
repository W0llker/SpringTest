package org.example.notNeedClasses.aop.annotationAspect;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component()
public class Person {
    @Value("Вася")
    private String name;
    @Value("Васек")
    private String surName;

    public void goWork() {
        System.out.println(name + " " + surName + " идет на работу");
    }
    public void goWork2() {
        System.out.println("2");
    }
}
