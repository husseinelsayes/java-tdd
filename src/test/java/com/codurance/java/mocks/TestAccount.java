package com.codurance.java.mocks;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TestAccount {
    
    private TransactionLogger transactionLogger = mock(TransactionLogger.class);
    private AccountService accountService = new Account(transactionLogger);

    // @BeforeEach
    // void setup(){
    //     accountService = new Account(transactionLogger);
    // }
    @Test
    public void shouldDepositMoney(){
        //GIVEN 
        accountService.deposit(1000);
        accountService.deposit(2000);
        accountService.withdraw(500);
        //WHEN USER PRINT BANK STATEMENT
        accountService.printStatement();
        //VERIFY THAT THE STATEMENT IS LOGGED TO CONSOLE
        verify(transactionLogger).logTransactions();
    }
}
