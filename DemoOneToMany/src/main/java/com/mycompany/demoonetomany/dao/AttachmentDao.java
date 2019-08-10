package com.mycompany.demoonetomany.dao;

import com.mycompany.demoonetomany.MyEntityManager;
import com.mycompany.demoonetomany.entity.Attachment;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import org.hibernate.Session;

/**
 *
 * @author namrata
 */
public class AttachmentDao {

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager = MyEntityManager.getEntityManager();

    public void insert(Attachment t) {
        entityManager.getTransaction().begin();
        entityManager.persist(t);
        entityManager.getTransaction().commit();
    }

    public void delete(Long id) {
        Attachment old = entityManager.find(Attachment.class, id);
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
    
    public void update(Long id, Attachment attachment) {

        try {
            entityManager.getTransaction().begin();
            Attachment old = entityManager.find(Attachment.class, id);
            old.setFilename(attachment.getFilename());
            old.setFilesize(attachment.getFilesize());
            old.setCreated(attachment.getCreated());
            old.setAttachementbBytes(attachment.getAttachementbBytes());
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction() != null) {
                entityManager.getTransaction().rollback();
            }
        }
    }
}
