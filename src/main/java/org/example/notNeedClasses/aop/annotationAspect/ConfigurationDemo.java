package org.example.notNeedClasses.aop.annotationAspect;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("org.example.notNeedClasses.aop.annotationAspect")
@EnableAspectJAutoProxy
public class ConfigurationDemo {
}
