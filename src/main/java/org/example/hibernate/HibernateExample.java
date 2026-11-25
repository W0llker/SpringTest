package org.example.hibernate;

import org.example.hibernate.config.HibernateConfig;
import org.example.hibernate.entity.Address;
import org.example.hibernate.entity.FacultyType;
import org.example.hibernate.entity.Group;
import org.example.hibernate.entity.Student;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.persistence.EntityManagerFactory;

public class HibernateExample {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);
        EntityManagerFactory entityManagerFactory = (EntityManagerFactory) context.getBean("entityManagerFactory");
        var entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();

            var group = new Group("2543", FacultyType.IT);

            var strudent = entityManager.find(Student.class, 2);
            group.addStudentToGroup(strudent);
            entityManager.merge(group);

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Exception in main: " + e);
            entityManager.getTransaction().rollback();

        } finally {
            entityManager.close();
        }
    }
}
