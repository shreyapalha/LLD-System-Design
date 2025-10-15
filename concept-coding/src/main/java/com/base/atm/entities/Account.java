package com.base.atm.entities;

import java.util.HashMap;

public class Account {
    private final String accountId;
    private double balance;
    private HashMap<String,Card> cards=new HashMap<>();

    public Account(String id,double balance){
        this.accountId=id;
        this.balance=balance;
    }

    public void setCard(Card card){
        this.cards.put(card.getNumber(), card);
    }

    public String getAccountId() {
        return accountId;
    }

    public double getBalance() {
        return balance;
    }

    public HashMap<String, Card> getCards() {
        return cards;
    }

    public synchronized boolean withdraw(double amount){
        if(balance>amount){
            balance=-amount;
            return true;
        }
        return false;
    }
}
