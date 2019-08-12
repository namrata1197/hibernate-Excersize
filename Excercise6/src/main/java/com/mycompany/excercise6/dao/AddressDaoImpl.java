package com.mycompany.excercise6.dao;

import com.mycompany.excercise6.EntityManagerUtil;
import com.mycompany.excercise6.entity.Address;
import com.mycompany.excercise6.entity.Users;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author namrata
 */
public class AddressDaoImpl implements AddressDao{

    private EntityManager entityManager = EntityManagerUtil.getEntityManager();
    
    @Override
    public void create(int userId, Address address) {
        try {
            entityManager.getTransaction().begin();
            Users user =  entityManager.find(Users.class, userId);
            user.getAddresses().add(address);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction() != null) {
                entityManager.getTransaction().rollback();
            }
        }
    }

    @Override
    public Address get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Address> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
