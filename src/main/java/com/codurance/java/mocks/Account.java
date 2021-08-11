package com.codurance.java.mocks;

public class Account implements AccountService{

    private TransactionLogger transactionLogger;
    private int balance = 0;

    public Account(TransactionLogger transactionLogger){
        this.transactionLogger = transactionLogger;
    }

    @Override
    public void deposit(int amount) {
        balance = balance + amount;
        transactionLogger.addTransaction(amount,balance);
    }

    @Override
    public void withdraw(int amount) {
        balance = balance - amount;
        transactionLogger.addTransaction(-amount,balance);
        
    }

    @Override
    public void printStatement() {
        transactionLogger.logTransactions();
    }
    
}
