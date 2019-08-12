package com.mycompany.excercise6.dao;


import com.mycompany.excercise6.entity.Address;
import java.util.List;

/**
 *
 * @author namrata
 */
public interface AddressDao {
    public void create(int userId, Address address);
    public Address get(int id);
    public List<Address> getAll();
}
