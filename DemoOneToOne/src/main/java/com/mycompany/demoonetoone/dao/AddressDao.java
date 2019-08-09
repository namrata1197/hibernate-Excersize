package com.mycompany.demoonetoone.dao;

import com.mycompany.demoonetoone.MyEntityManager;
import com.mycompany.demoonetoone.entity.Address;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

/**
 *
 * @author namrata
 */
public class AddressDao {
     @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager = MyEntityManager.getEntityManager();

    public void addAddress(Address user) {
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }
}
