package com.mycompany.excercise6.dao;

import com.mycompany.excercise6.entity.Shipment;
import java.util.List;

/**
 *
 * @author namrata
 */
public interface ShipmentDao {
    public void create(int itemId, int buyerId, int sallerId, int addresId, Shipment shipment);
    public Shipment get(int id);
    public List<Shipment> getAll();
}
