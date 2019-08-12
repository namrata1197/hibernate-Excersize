package com.mycompany.excercise6.dao;

import com.mycompany.excercise6.entity.Comment;
import java.util.List;

/**
 *
 * @author namrata
 */
public interface CommentDao {
    public void create(int userId, int itemId, Comment comment);
    public Comment get(int id);
    public List<Comment> getAll();
}
