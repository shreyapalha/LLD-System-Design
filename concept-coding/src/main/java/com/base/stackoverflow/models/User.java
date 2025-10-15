package com.base.stackoverflow.models;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class User {
    private final String id;

    private final String name;

    private final AtomicInteger reputation;

    public User(String name){
        this.id= UUID.randomUUID().toString();
        this.name=name;
        reputation=new AtomicInteger(0);
    }

    public void updateReputation(int value){
        reputation.addAndGet(value);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public AtomicInteger getReputation() {
        return reputation;
    }
}
