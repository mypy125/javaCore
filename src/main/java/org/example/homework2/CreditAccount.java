package org.example.homework2;

public class CreditAccount extends Account{
    private Transaction transaction;
    private CreditAccount(String name, String surname, int phone, double check,String password) {
        super(name, surname, phone, check,password);
    }
}
