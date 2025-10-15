package com.base.stackoverflow.observers;

import com.base.stackoverflow.enums.EventType;
import com.base.stackoverflow.models.Event;
import com.base.stackoverflow.models.User;

public class ReputationManager implements PostObserver{

    @Override
    public void onPostEvent(Event event) {
        User postAuthor=event.getTargetPost().getAuthor();
        switch (event.getEventType()) {
            case UPVOTE_ANSWER:
                postAuthor.updateReputation(10);
                break;
            case UPVOTE_QUESTION:
                postAuthor.updateReputation(5);
                break;
            case DOWNVOTE_ANSWER:
                postAuthor.updateReputation(-10);
                break;
            case DOWNVOTE_QUESTION:
                postAuthor.updateReputation(-5);
                break;
            case ANSWER_ACCEPTED:
                postAuthor.updateReputation(20);
                break;
        }
    }
}
