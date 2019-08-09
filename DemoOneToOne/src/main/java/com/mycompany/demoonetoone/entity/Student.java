package com.mycompany.demoonetoone.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Email;

/**
 *
 * @author namrata
 */
@Entity
@Table(name = "student")

public class Student{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sid")
    private int sid;
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "middlename")
    private String middlename;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "prefix")
    private String prefix;
    @Column(name = "suffix")
    private String suffix;
    @Column(name = "email")
    @Email
    private String email;
    @Column(name = "phone")
    private String phone;

    @Embedded
@AttributeOverrides({
  @AttributeOverride( name = "stree1", column = @Column(name = "add_stree1")),
  @AttributeOverride( name = "street2", column = @Column(name = "add_stree2")),
  @AttributeOverride( name = "city", column = @Column(name = "add_city")),
  @AttributeOverride( name = "state", column = @Column(name = "add_state")),
  @AttributeOverride( name = "county", column = @Column(name = "add_county")),
  @AttributeOverride( name = "country", column = @Column(name = "add_country"))
})
    private Address address;
    
    @JoinColumn(name = "eid",referencedColumnName = "eid")
    @OneToOne(
        cascade = CascadeType.ALL,
        orphanRemoval = true
    ) 
    private Education education;

    public Student(String firstname, String middlename, String lastname, String prefix, String suffix, String email, String phone, Address address, Education education) {
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.prefix = prefix;
        this.suffix = suffix;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.education = education;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }
    
    public Student() {
    }


    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "com.mycompany.demoonetoone.Student[ sid=" + sid + " ]";
    }
    
}
