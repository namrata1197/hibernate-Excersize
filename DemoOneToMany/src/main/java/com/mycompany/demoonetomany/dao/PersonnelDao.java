package com.mycompany.demoonetomany.dao;

import com.mycompany.demoonetomany.MyEntityManager;
import com.mycompany.demoonetomany.entity.Personnel;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import org.hibernate.Session;

/**
 *
 * @author namrata
 */
public class PersonnelDao {

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager = MyEntityManager.getEntityManager();

    public void insert(Personnel t) {
        entityManager.getTransaction().begin();
        entityManager.persist(t);
        entityManager.getTransaction().commit();
    }

    public void delete(Long id) {
        Personnel old = entityManager.find(Personnel.class, id);
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

    public void update(Long id, Personnel proposal) {

        try {
            entityManager.getTransaction().begin();
            Personnel old = entityManager.find(Personnel.class, id);
            old.setName(proposal.getName());
            old.setPhone(proposal.getPhone());
            old.setQl(proposal.getQl());
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction() != null) {
                entityManager.getTransaction().rollback();
            }
        }
    }
}
