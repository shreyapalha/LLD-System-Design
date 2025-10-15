package com.base.stackoverflow.models;

import com.base.stackoverflow.enums.EventType;

public class Event {
    private final User user;
    private final Post targetPost;
    private final EventType eventType;

    public Event(User user, Post post, EventType eventType) {
        this.user = user;
        this.targetPost = post;
        this.eventType = eventType;
    }

    public User getUser() {
        return user;
    }

    public Post getTargetPost() {
        return targetPost;
    }

    public EventType getEventType() {
        return eventType;
    }
}
