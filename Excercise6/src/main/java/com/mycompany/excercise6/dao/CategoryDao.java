package com.mycompany.excercise6.dao;

import com.mycompany.excercise6.entity.Category;
import java.util.List;

/**
 *
 * @author namrata
 */
public interface CategoryDao {
    public void create(Category category);
    public Category get(int id);
    public List<Category> getAll();
}
