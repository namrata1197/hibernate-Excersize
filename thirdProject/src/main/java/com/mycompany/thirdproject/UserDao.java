package com.mycompany.thirdproject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import org.hibernate.Session;

/**
 *
 * @author namrata
 */
public class UserDao {

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager = MyEntityManager.getEntityManager();

    public void addUser(User user) {
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }

    public void listAllUsers() {
        List<User> list = new ArrayList<>();
        try {
            list = entityManager.createQuery("SELECT p from User p", User.class).getResultList();
            for (Iterator iterator = list.iterator(); iterator.hasNext();) {
                User user = (User) iterator.next();
                System.out.print("Name: " + user.getName());
                System.out.print("  Phone: " + user.getPhone());
                System.out.println("");
            }
            System.out.println("");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getUser(int id) {
        User user;
        try {
            user = entityManager.find(User.class, id);
            System.out.print("Name: " + user.getName());
            System.out.print("  Phone: " + user.getPhone());
            System.out.println("");
            System.out.println("");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeUser(int id) {
        User old = entityManager.find(User.class, id);
        EntityTransaction tx = null;
        Session session = null;

        try {
            session = entityManager.unwrap(Session.class);
            tx = entityManager.getTransaction();
            tx.begin();
            entityManager.remove(old);
            tx.commit();
        } catch (Exception e) {
        }

    }
}
