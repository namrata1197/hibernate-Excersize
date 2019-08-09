package com.mycompany.thirdproject;

/**
 *
 * @author namrata
 */
public class MyApp {

    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        User u1 = new User("namrata2", "9870878906");
        userDao.addUser(u1);
        userDao.listAllUsers();
        userDao.removeUser(4);
        userDao.getUser(2);
        userDao.listAllUsers();
    }
}
