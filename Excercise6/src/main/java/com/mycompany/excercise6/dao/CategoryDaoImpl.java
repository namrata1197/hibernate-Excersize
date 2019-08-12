package com.mycompany.excercise6.dao;

import com.mycompany.excercise6.EntityManagerUtil;
import com.mycompany.excercise6.entity.Category;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author namrata
 */
public class CategoryDaoImpl implements CategoryDao {

    private EntityManager entityManager = EntityManagerUtil.getEntityManager();

    @Override
    public void create(Category category) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(category);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction() != null) {
                entityManager.getTransaction().rollback();
            }
        }
    }

    @Override
    public Category get(int id) {
        Category category = null;
        try {
            category = entityManager.find(Category.class, id);
        } catch (Exception e) {
        }
        return category;
    }

    @Override
    public List<Category> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
