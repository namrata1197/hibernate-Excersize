package com.mycompany.demoonetoone.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author namrata
 */
@Entity
@Table(name = "education")
public class Education implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "eid")
    private Integer eid;
    @Column(name = "degree_type")
    private String degreeType;
    @Column(name = "degree_decription")
    private String degreeDecription;
    @Column(name = "graduation_year")
    private String graduationYear;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    @Column(name = "school")
    private String school;
    
    @JoinColumn(name = "sid",referencedColumnName = "sid")
    @OneToOne(
        cascade = CascadeType.ALL,
        orphanRemoval = true
    ) 
    private Student student;

    public Education() {
    }

    public String getDegreeType() {
        return degreeType;
    }

    public void setDegreeType(String degreeType) {
        this.degreeType = degreeType;
    }

    public String getDegreeDecription() {
        return degreeDecription;
    }

    public void setDegreeDecription(String degreeDecription) {
        this.degreeDecription = degreeDecription;
    }

    public Education(String degreeType, String degreeDecription, String graduationYear, String school, Student student) {
        this.degreeType = degreeType;
        this.degreeDecription = degreeDecription;
        this.graduationYear = graduationYear;
        this.school = school;
        this.student = student;
    }

    public String getGraduationYear() {
        return graduationYear;
    }

    public void setGraduationYear(String graduationYear) {
        this.graduationYear = graduationYear;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eid != null ? eid.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "com.mycompany.demoonetoone.Education[ eid=" + eid + " ]";
    }
    
}
