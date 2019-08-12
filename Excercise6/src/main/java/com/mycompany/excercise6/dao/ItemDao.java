package com.mycompany.excercise6.dao;

import com.mycompany.excercise6.entity.Item;
import java.util.List;

/**
 *
 * @author namrata
 */
public interface ItemDao {
    public void create(int sallerId, Item item);
    public Item get(int id);
    public List<Item> getAll();
}
