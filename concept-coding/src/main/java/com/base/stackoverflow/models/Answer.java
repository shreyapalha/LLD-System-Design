package com.base.stackoverflow.models;

public class Answer extends Post{

    private boolean isAccepted;

    public Answer(String body, User user) {
        super(body, user);
        isAccepted=false;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public void setAccepted(boolean accepted) {
        isAccepted = accepted;
    }
}
