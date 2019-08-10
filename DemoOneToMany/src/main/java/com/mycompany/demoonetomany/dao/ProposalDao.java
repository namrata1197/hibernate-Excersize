package com.mycompany.demoonetomany.dao;

import com.mycompany.demoonetomany.MyEntityManager;
import com.mycompany.demoonetomany.entity.Proposal;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import org.hibernate.Session;

/**
 *
 * @author namrata
 */
public class ProposalDao {

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager = MyEntityManager.getEntityManager();

    public void insert(Proposal t) {
        entityManager.getTransaction().begin();
        entityManager.persist(t);
        entityManager.getTransaction().commit();
    }

    public void delete(Long id) {
        Proposal old = entityManager.find(Proposal.class, id);
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

    public void update(Long id, Proposal proposal) {

        try {
            entityManager.getTransaction().begin();
            Proposal old = entityManager.find(Proposal.class, id);
            old.setComment(proposal.getComment());
            old.setTitle(proposal.getTitle());
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction() != null) {
                entityManager.getTransaction().rollback();
            }
        }
    }
}
