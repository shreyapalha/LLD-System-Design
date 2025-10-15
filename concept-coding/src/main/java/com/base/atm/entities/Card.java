package com.base.atm.entities;

public class Card {
    private final String number;
    private final String pin;

    public Card(String number,String pin){
        this.number=number;
        this.pin=pin;
    }

    public String getNumber() {
        return number;
    }

    public String getPin() {
        return pin;
    }
}
