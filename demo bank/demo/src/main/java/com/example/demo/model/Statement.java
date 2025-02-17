package com.example.demo.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Statement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int statementId;

    private String date;
    private int amount;
    private String type;

    @ManyToOne
    @JoinColumn(name = "bank_detalis",referencedColumnName = "account_number")
    private BankDetalis bankDetalis;

    public long getStatementId() {
        return statementId;
    }

    public void setStatementId(int   statementId) {
        this.statementId = statementId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BankDetalis getBankDetalis() {
        return bankDetalis;
    }

    public void setBankDetalis(BankDetalis bankDetalis) {
        this.bankDetalis = bankDetalis;
    }
}