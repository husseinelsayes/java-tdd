package com.codurance.java.mocks;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TransactionLogger {

    List<Transaction> transactions = new ArrayList<Transaction>();

    public void addTransaction(int amount,int balance){
        transactions.add(new Transaction(LocalDate.now(), amount, balance));
    }


    public void logTransactions(){
        System.out.println("Date       || Amount  || Balance");
        for(Transaction transaction : transactions){
            System.out.println(transaction);
        } 
    }
}
