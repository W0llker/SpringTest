package org.example.notNeedClasses.aop.introduction;

import org.springframework.aop.IntroductionAdvisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultIntroductionAdvisor;

public class IntroductionDemo {
    public static void main(String[] args) {
        Contact contact = new Contact();
        contact.setName("John");

        IntroductionAdvisor advisor = new IsModifiedAdvisor();

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(contact);
        proxyFactory.addAdvisor(advisor);
        proxyFactory.setOptimize(true);

        Contact proxyContact = (Contact) proxyFactory.getProxy();
        IsModified modified = (IsModified) proxyFactory.getProxy();


        System.out.println(modified.isModified());
        proxyContact.setName("Josdsdn");
        System.out.println(modified.isModified());

        System.out.println(proxyContact.getName());
    }
}
