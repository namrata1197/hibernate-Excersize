package com.mycompany.demoonetomany.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

/**
 *
 * @author namrata
 */
@Entity
@Table(name = "personnel")
public class Personnel {

    @Id
//    @Column(name = "pid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public QualificationLevel getQl() {
        return ql;
    }

    public void setQl(QualificationLevel ql) {
        this.ql = ql;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Personnel() {
    }

    public Personnel(String name, QualificationLevel ql, String phone) {
        this.name = name;
        this.ql = ql;
        this.phone = phone;
    }

    @Column(name = "name")
    private String name;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "qualificationLevel", column = @Column(name = "qualificationLevel"))
    })
    private QualificationLevel ql;

    @Column(name = "phone")
    @Min(value = 10)
    @Pattern(regexp = "[9876]{1}[0-9]{9}")
    private String phone;
}
