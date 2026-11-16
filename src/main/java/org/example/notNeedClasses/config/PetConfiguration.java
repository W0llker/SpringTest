package org.example.notNeedClasses.config;

import org.example.notNeedClasses.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.example")
public class PetConfiguration {
    @Bean
    public Dog dog() {
        return new Dog();
    }
}
