package com.mycompany.excercise6.dao;

import com.mycompany.excercise6.EntityManagerUtil;
import com.mycompany.excercise6.entity.Comment;
import com.mycompany.excercise6.entity.Item;
import com.mycompany.excercise6.entity.Users;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author namrata
 */
public class CommentDaoImpl implements CommentDao {

    private EntityManager entityManager = EntityManagerUtil.getEntityManager();

    @Override
    public void create(int userId, int itemId, Comment comment) {
        try {
            entityManager.getTransaction().begin();
            comment.setUser(entityManager.find(Users.class, userId));
            comment.setItem(entityManager.find(Item.class, userId));
            entityManager.persist(comment);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction() != null) {
                entityManager.getTransaction().rollback();
            }
        }
    }

    @Override
    public Comment get(int id) {
        Comment comment = null;
        try {
            comment = entityManager.find(Comment.class, id);
        } catch (Exception e) {
        }
        return comment;
    }

    @Override
    public List<Comment> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
