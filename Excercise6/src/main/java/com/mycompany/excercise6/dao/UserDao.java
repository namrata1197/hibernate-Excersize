package com.mycompany.excercise6.dao;

import com.mycompany.excercise6.entity.Users;
import java.util.List;

/**
 *
 * @author namrata
 */
public interface UserDao {
    public void create(Users user);
    public Users get(int id);
    public List<Users> getAll();
}
