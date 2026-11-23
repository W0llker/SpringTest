package org.example.notNeedClasses.aop;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;

public class AgentPointcutAdvisor extends StaticMethodMatcherPointcut {
    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        return method.getName().equals("speak");
    }

    @Override
    public ClassFilter getClassFilter() {
        return cs -> (cs == Agent.class);
    }
}
