/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hibernatefirstproject;

/**
 *
 * @author namrata
 */
public class App {

    

    public static void main(String[] args) {
        StudentDao a = new StudentDao();

        

        int id1 = a.addStudent("Zara", "Ali", "sadd@gamil.com");
        int id2 = a.addStudent("Daisy", "Das", "hd@gamil.com");
        int id3 = a.addStudent("John", "Paul", "guytgu@gamil.com");

        a.listStudent();

        a.updateStudent(id1, "huguy@gamil.com");

        a.deleteStudent(id2);

        a.listStudent();
    
    }

}
