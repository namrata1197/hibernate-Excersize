package com.mycompany.excercise6;

import com.mycompany.excercise6.dao.AddressDao;
import com.mycompany.excercise6.dao.AddressDaoImpl;
import com.mycompany.excercise6.dao.BidDao;
import com.mycompany.excercise6.dao.BidDaoImpl;
import com.mycompany.excercise6.dao.BillingDetailsDao;
import com.mycompany.excercise6.dao.BillingDetailsDaoImpl;
import com.mycompany.excercise6.dao.CategoryDao;
import com.mycompany.excercise6.dao.CategoryDaoImpl;
import com.mycompany.excercise6.dao.CommentDao;
import com.mycompany.excercise6.dao.CommentDaoImpl;
import com.mycompany.excercise6.dao.ItemDao;
import com.mycompany.excercise6.dao.ItemDaoImpl;
import com.mycompany.excercise6.dao.ShipmentDao;
import com.mycompany.excercise6.dao.ShipmentDaoImpl;
import com.mycompany.excercise6.dao.UserDao;
import com.mycompany.excercise6.dao.UserDaoImpl;
import com.mycompany.excercise6.entity.Address;
import com.mycompany.excercise6.entity.AddressType;
import com.mycompany.excercise6.entity.Bid;
import com.mycompany.excercise6.entity.BillingDetails;
import com.mycompany.excercise6.entity.Category;
import com.mycompany.excercise6.entity.Comment;
import com.mycompany.excercise6.entity.CreditCard;
import com.mycompany.excercise6.entity.CreditCardType;
import com.mycompany.excercise6.entity.Item;
import com.mycompany.excercise6.entity.ItemState;
import com.mycompany.excercise6.entity.Rating;
import com.mycompany.excercise6.entity.Shipment;
import com.mycompany.excercise6.entity.ShipmentState;
import com.mycompany.excercise6.entity.Users;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author namrata
 */
public class MyApp {
    public static void main(String[] args) {
        AddressDao addressRepo = new AddressDaoImpl();
        BidDao bidRepo = new BidDaoImpl();
        BillingDetailsDao billingDetailsRepo = new BillingDetailsDaoImpl();
        CategoryDao categoryRepo = new CategoryDaoImpl();
        CommentDao commentRepo = new CommentDaoImpl();
        ItemDao itemRepo = new ItemDaoImpl();
        ShipmentDao shipmentRepo = new ShipmentDaoImpl();
        UserDao userRepo = new UserDaoImpl();

        Users user = new Users();
        user.setFirstname("Rahul");
        user.setLastname("Raiyani");
        user.setUsername("rraiyani");
        user.setPassword("namrata");
        user.setRanking(1);
        user.setEmail("namrata.raiyani@gmail.com");
        List<Address> addresses = new ArrayList<>();
        addresses.add(new Address("first", "356232", "surat", AddressType.home));
        user.setAddresses(addresses);
        userRepo.create(user);

        Address add = new Address("second", "356232", "surat", AddressType.work);
        addressRepo.create(1, add);
        CreditCard card = new CreditCard(CreditCardType.GoldCreditCard, "1232123212321232", "12", "2025");
        BillingDetails billing = new BillingDetails("Nihar");
        billing.setCredit_card_id(card);
        billingDetailsRepo.create(1, billing);

        Category category = new Category("itemcat");
        Item item = new Item("Pencil", "dd", Long.MIN_VALUE, Long.MIN_VALUE, LocalDate.MAX, LocalDate.MAX, ItemState.dispatched, LocalDateTime.MIN, category);
        itemRepo.create(1, item);

        
        Bid bid = new Bid(Long.MAX_VALUE, LocalDate.MAX);
        bidRepo.create(1, 1, bid);

        Comment comment = new Comment(Rating.medium, "text", LocalDate.MAX);
        commentRepo.create(1, 1, comment);

        Shipment shipment = new Shipment(5, ShipmentState.dispatched, LocalDate.MAX);
        shipmentRepo.create(1, 1, 1, 1, shipment);

        Category category1 = categoryRepo.get(2);
        Category category2 = new Category("new one");
        category2.setParent(category1);
        categoryRepo.create(category2);
    }
}
