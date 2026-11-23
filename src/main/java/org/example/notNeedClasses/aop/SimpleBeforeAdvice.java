package org.example.notNeedClasses.aop;

import org.springframework.aop.Advisor;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.lang.Nullable;

import java.lang.reflect.Method;

public class SimpleBeforeAdvice implements MethodBeforeAdvice {
    public static void main(String[] args) {
        Agent agent = new Agent();
        Pointcut pointcut = new AgentPointcutAdvisor();
        //Объединяем совет с срезом и добавляем в наш прокси фактори
        Advisor advisor = new DefaultPointcutAdvisor(pointcut, new SimpleBeforeAdvice());

        ProxyFactory pf = new ProxyFactory();
        pf.addAdvisor(advisor);
        pf.setTarget(agent);


        Agent proxy = (Agent) pf.getProxy();
        proxy.speak();
    }

    @Override
    public void before(Method method, Object[] args, @Nullable Object target) throws Throwable {
        System.out.println("before: " + method.getName());
    }
}
