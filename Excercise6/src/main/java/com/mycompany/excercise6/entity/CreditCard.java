package com.mycompany.excercise6.entity;

import javax.persistence.*;
import javax.validation.constraints.*;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 *
 * @author namrata
 */

@Entity
@Table(name = "creditcard")
public class CreditCard {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "type")
    @NotNull
    private CreditCardType type;
    
    @Column(name = "number", length = 16)
    @NotNull @Min(value = 16)
    private String number;
    
    @Column(name = "expmonth", length = 2)
    @NotNull @Min(value = 2)
    private String expmonth;
    
    @Column(name = "expyear", length = 4)
    @NotNull @Min(value = 4)
    private String expyear;
    
    public CreditCard() {
    }

    public CreditCard(CreditCardType type, String number, String expmonth, String expyear) {
        this.type = type;
        this.number = number;
        this.expmonth = expmonth;
        this.expyear = expyear;
    }
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CreditCardType getType() {
        return type;
    }

    public void setType(CreditCardType type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getExpmonth() {
        return expmonth;
    }

    public void setExpmonth(String expmonth) {
        this.expmonth = expmonth;
    }

    public String getExpyear() {
        return expyear;
    }

    public void setExpyear(String expyear) {
        this.expyear = expyear;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this,ToStringStyle.MULTI_LINE_STYLE);
    }
}
