package com.base.pubsub.entities;

import java.time.LocalDateTime;

public class Message {
    private final String message;
    private final LocalDateTime timestamp;

    public Message(String message){
        this.timestamp=LocalDateTime.now();
        this.message=message;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
