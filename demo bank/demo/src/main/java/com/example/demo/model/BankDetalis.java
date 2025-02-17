package com.example.demo.model;

import jakarta.persistence.*;


import java.util.List;
import java.util.UUID;

@Entity

@Table(name="bank_detalis")
public class BankDetalis {
    @Id
    @Column(name = "account_number")
    private String accountnumber= UUID.randomUUID().toString().replaceAll("[^0-9]","").substring(0,9);

    @Column(name="balance")
    private int balance;
    ;



    @Column(name="custmer_name")
    private String custmername;


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "bankDetalis")
    private List<Statement>statements;

    public List<Statement> getStatements() {
        return statements;
    }

    public void setStatements(List<Statement> statements) {
        this.statements = statements;
    }

    public String getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(String accountnumber) {
        this.accountnumber = accountnumber;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getCustmername() {
        return custmername;
    }

    public void setCustmername(String custmername) {
        this.custmername = custmername;
    }

}
