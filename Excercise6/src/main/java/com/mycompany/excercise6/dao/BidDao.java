package com.mycompany.excercise6.dao;

import com.mycompany.excercise6.entity.Bid;
import java.util.List;

/**
 *
 * @author namrata
 */
public interface BidDao {
    public void create(int userId, int itemId, Bid bid);
    public Bid get(int id);
    public List<Bid> getAll();
}
