package org.example.notNeedClasses.aop.annotationAspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect; 
import org.springframework.stereotype.Component;

@Aspect
@Component()
public class PersonAspectJ {
    @Around("execution(* org.example.notNeedClasses.aop.annotationAspect.Person.go*())")
    public void test(ProceedingJoinPoint pjp) throws Throwable {
        pjp.getSignature().getName(); // получаем имя метода
        pjp.getArgs(); // получаем аргументы метода
        System.out.println("test");
        pjp.proceed(); // возвращает полученное значение метода
        System.out.println("test");
    }
}
