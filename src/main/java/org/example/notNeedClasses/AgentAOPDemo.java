package org.example.notNeedClasses;

import org.example.notNeedClasses.aop.Agent;
import org.example.notNeedClasses.aop.AgentDecorator;
import org.springframework.aop.framework.ProxyFactory;

public class AgentAOPDemo {
    public static void main(String[] args) {
        Agent agent = new Agent();
        ProxyFactory pf = new ProxyFactory();
        pf.addAdvice(new AgentDecorator());
        pf.setTarget(agent);

        Agent proxy = (Agent) pf.getProxy();
        proxy.speak();
    }
}
