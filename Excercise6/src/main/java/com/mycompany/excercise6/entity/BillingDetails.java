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
@Table(name = "billingdetails")
public class BillingDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ownername", length = 30)
    @NotNull
    private String ownername;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "credit_card_id")
    private CreditCard credit_card_id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bank_account_id")
    private BankAccount bank_account_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @NotNull
    private Users user;

    public BillingDetails() {
    }

    public BillingDetails(String ownername) {
        this.ownername = ownername;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOwnername() {
        return ownername;
    }

    public void setOwnername(String ownername) {
        this.ownername = ownername;
    }

    public CreditCard getCredit_card_id() {
        return credit_card_id;
    }

    public void setCredit_card_id(CreditCard credit_card_id) {
        this.credit_card_id = credit_card_id;
    }

    public BankAccount getBank_account_id() {
        return bank_account_id;
    }

    public void setBank_account_id(BankAccount bank_account_id) {
        this.bank_account_id = bank_account_id;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this,ToStringStyle.MULTI_LINE_STYLE);
    }

}
