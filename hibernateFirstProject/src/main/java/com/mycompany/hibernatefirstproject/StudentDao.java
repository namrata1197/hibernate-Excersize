
package com.mycompany.hibernatefirstproject;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StudentDao {
    private static SessionFactory factory;
    private final String PATH="/home/namrata/NetBeansProjects/hibernate/hibernateFirstProject/src/main/resources/META-INF/hibernate.cfg.xml";
    public StudentDao(){
        try {
            Configuration cfg = new Configuration();
            cfg.addAnnotatedClass(com.mycompany.hibernatefirstproject.Student.class);
            factory = cfg.configure(new File(PATH)).buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public Integer addStudent(String fname, String lname, String email) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer id = null;

        try {
            tx = session.beginTransaction();
            Student student = new Student(fname, lname, email);
            id = (Integer) session.save(student);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return id;
    }

    public void listStudent() {
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            List employees = session.createQuery("FROM Student").list();
            for (Iterator iterator = employees.iterator(); iterator.hasNext();) {
                Student student = (Student) iterator.next();
                System.out.print("First Name: " + student.getFirstName());
                System.out.print("  Last Name: " + student.getLastName());
                System.out.println("  Email: " + student.getEmail());
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void updateStudent(int id, String email) {
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Student student = (Student) session.get(Student.class, id);
            student.setEmail(email);
            session.update(student);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void deleteStudent(int id) {
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Student student = (Student) session.get(Student.class, id);
            session.delete(student);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
