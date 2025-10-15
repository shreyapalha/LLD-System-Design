package com.base.stackoverflow.models;

import java.time.LocalDateTime;
import java.util.UUID;

public class Content {
    private final String id;
    private final String body;
    private final LocalDateTime timestamp;
    private final User author;

    public Content(String body, User user){
        this.id= UUID.randomUUID().toString();
        this.body=body;
        this.author=user;
        this.timestamp=LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public User getAuthor() {
        return author;
    }


}
