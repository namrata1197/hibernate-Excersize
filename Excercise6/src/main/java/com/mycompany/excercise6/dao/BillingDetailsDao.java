package com.mycompany.excercise6.dao;

import com.mycompany.excercise6.entity.BillingDetails;
import java.util.List;

/**
 *
 * @author namrata
 */
public interface BillingDetailsDao {
    public void create(int userId, BillingDetails billingDetail);
    public BillingDetails get(int id);
    public List<BillingDetails> getAll();
}
