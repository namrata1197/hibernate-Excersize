
package com.mycompany.hibernatesecondproject;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class MyApp {

    private static EntityManager em;

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("Student");
        em = emf.createEntityManager();

        createStudent("Ravi", "Raj", "vdfvbgf@gmail.com");
        createStudent("Amit", "Raj", "juihui@gmail.com");
        createStudent("Nitish", "Kumar", "grtygr@gmail.com");

    }

    private static void createStudent(String firstName,
            String lastName, String email) {
        em.getTransaction().begin();
        Student emp = new Student(firstName, lastName, email);
        em.persist(emp);
        em.getTransaction().commit();
    }
}
