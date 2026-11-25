package org.example.notNeedClasses.aop.annotationAspect;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Demo {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigurationDemo.class);
        Person person = (Person) context.getBean("person");
        person.goWork();
        person.goWork2();
    }
}
