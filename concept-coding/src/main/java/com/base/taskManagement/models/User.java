package com.base.taskManagement.models;

import java.util.List;
import java.util.UUID;

public class User {
    private final String id;

    private String username;

    private String email;

    public User(String username,String email){
        this.id= UUID.randomUUID().toString();
        this.username=username;
        this.email=email;
    }

    //getters and setters
    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
