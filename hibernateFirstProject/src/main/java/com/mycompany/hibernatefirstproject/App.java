package com.mycompany.hibernatefirstproject;

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
