package org.example.notNeedClasses.config;

import org.example.notNeedClasses.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VehicleConfiguration {
    @Bean
    public Motorbike motorbike() {
        return new Motorbike();
    }

    @Bean
    public Car car() {
        return new Car();
    }

    //1 Вариант
//    @Bean
//    public Person person(Dog dog) {
//        return new Person(car(), dog);
//    }
    //2 Вариант -> лучше связывать объекты через аргументы, а не вызов методов
    @Bean
    public Person person(@Qualifier("car") Vehicle vehicle, Dog dog) {
        return new Person(vehicle, dog);
    }
}
