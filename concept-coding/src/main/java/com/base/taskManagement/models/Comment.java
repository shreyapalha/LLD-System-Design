package com.base.taskManagement.models;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

public class Comment {
    private final String id;
    private String content;
    private User user;
    private LocalDateTime currentTime;

    public Comment(String content,User user){
        this.id= UUID.randomUUID().toString();
        this.content=content;
        this.user=user;
    }

}
