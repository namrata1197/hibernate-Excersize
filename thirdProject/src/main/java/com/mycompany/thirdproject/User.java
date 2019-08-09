
package com.mycompany.thirdproject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author namrata
 */
@Entity
@Table(name="user1", 
        uniqueConstraints = {
        @UniqueConstraint(columnNames = {"name","phone"})
        })
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    
    @Column(name="name", length=20)
    private String name;
    
    @Column(name="phone" , length=10)
    private String phone;
    
    public User(){
        
    }
    
    public User( String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", phone=" + phone + '}';
    }
    
    
}
