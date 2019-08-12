package com.mycompany.excercise6.dao;

import com.mycompany.excercise6.EntityManagerUtil;
import com.mycompany.excercise6.entity.Item;
import com.mycompany.excercise6.entity.Users;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author namrata
 */
public class ItemDaoImpl implements ItemDao {

    private EntityManager entityManager = EntityManagerUtil.getEntityManager();

    @Override
    public void create(int sallerId, Item item) {
        try {
            entityManager.getTransaction().begin();
            Users user = entityManager.find(Users.class, sallerId);
            user.getItems().add(item);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction() != null) {
                entityManager.getTransaction().rollback();
            }
        }
    }

    @Override
    public Item get(int id) {
        Item item = null;
        try {
            item = entityManager.find(Item.class, id);
        } catch (Exception e) {
        }
        return item;
    }

    @Override
    public List<Item> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
