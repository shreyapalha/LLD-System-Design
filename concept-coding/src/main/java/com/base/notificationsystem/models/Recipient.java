package com.base.notificationsystem.models;

import java.util.Optional;
import java.util.UUID;

public class Recipient {
    private final String id;
    private final Optional<String> email;
    private final Optional<String> phoneNumber;
    private final Optional<String> tokens;

    public Recipient(String email,String phoneNumber,String tokens){
        this.id= UUID.randomUUID().toString();
        this.email=Optional.ofNullable(email);
        this.phoneNumber=Optional.ofNullable(phoneNumber);
        this.tokens=Optional.ofNullable(tokens);
    }

    public String getId() {
        return id;
    }

    public Optional<String> getEmail() {
        return email;
    }

    public Optional<String> getPhoneNumber() {
        return phoneNumber;
    }

    public Optional<String> getTokens() {
        return tokens;
    }
}
