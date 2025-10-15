package com.base.atm.services;

import com.base.atm.entities.Account;
import com.base.atm.entities.Card;

import java.util.HashMap;
import java.util.Map;

public class BankServices {
    private final Map<String, Account> accounts=new HashMap<>();
    private final Map<String, Card> cards=new HashMap<>();

    public BankServices(){
        Account a1=new Account("1234",5000.0);
        Account a2=new Account("1235",6000.0);
        accounts.put(a1.getAccountId(),a1);
        accounts.put(a2.getAccountId(),a2);

        Card c1=new Card("4521-3214","3567");
        Card c2=new Card("4521-3215","6537");

        cards.put(c1.getNumber(),c1);
        cards.put(c2.getNumber(), c2);

        mapAccountToCard(a1,c1);
        mapAccountToCard(a2,c2);
    }

    public void mapAccountToCard(Account a1, Card c1) {
        a1.getCards().put(c1.getNumber(),c1);
    }

    public boolean isAuthenticated(Card card,String pin){
        if(card.getPin().equals(pin)){
            return true;
        }
        return false;
    }


}
