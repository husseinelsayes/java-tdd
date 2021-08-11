package com.codurance.java.mocks;

import java.time.LocalDate;

public class Transaction {
    private LocalDate date;
    private int amount;
    private int balance;


    public Transaction(LocalDate date, int amount, int balance) {
        this.date = date;
        this.amount = amount;
        this.balance = balance;
    }


    @Override
    public String toString() {
        return date + " || " + amount + " || " + balance;
    }

}
