package com.mycompany.excercise6.dao;

import com.mycompany.excercise6.EntityManagerUtil;
import com.mycompany.excercise6.entity.BillingDetails;
import com.mycompany.excercise6.entity.Users;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author namrata
 */
public class BillingDetailsDaoImpl implements BillingDetailsDao{

    private EntityManager entityManager = EntityManagerUtil.getEntityManager();
    
    @Override
    public void create(int userId, BillingDetails billing) {
        try {
            entityManager.getTransaction().begin();
            Users user = entityManager.find(Users.class, userId);
            user.getBillings().add(billing);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction() != null) {
                entityManager.getTransaction().rollback();
            }
        }
    }

    @Override
    public BillingDetails get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<BillingDetails> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
