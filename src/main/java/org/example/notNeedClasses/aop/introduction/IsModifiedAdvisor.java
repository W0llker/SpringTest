package org.example.notNeedClasses.aop.introduction;

import org.springframework.aop.support.DefaultIntroductionAdvisor;
//Советник
public class IsModifiedAdvisor extends DefaultIntroductionAdvisor {
    public IsModifiedAdvisor() {
        super(new IsModifiedMixin());
    }
}
