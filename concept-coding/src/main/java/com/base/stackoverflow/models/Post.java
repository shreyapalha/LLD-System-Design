package com.base.stackoverflow.models;

import com.base.stackoverflow.enums.EventType;
import com.base.stackoverflow.enums.VoteType;
import com.base.stackoverflow.observers.PostObserver;
import com.base.stackoverflow.observers.ReputationManager;
import com.base.taskManagement.models.Comment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Post extends Content{

    private final AtomicInteger voteCount=new AtomicInteger(0);
    private final Map<String, VoteType> votes=new ConcurrentHashMap<>();
    private final List<PostObserver> postObservers=new ArrayList<>();
    private final List<Comment> comments=new ArrayList<>();

    public Post(String body, User user) {
        super(body, user);
    }

    public void addObserver(PostObserver postObserver){
        postObservers.add(postObserver);
    }

    public void notifyObservers(Event event){
        for(PostObserver postObserver:postObservers){
            postObserver.onPostEvent(event);
        }
    }

    public void vote(User user,VoteType voteType){
        String id= user.getId();
        if(votes.get(id)==voteType){
            System.out.println("User not allowed to again");
            return;
        }
        int count=0;
        if(votes.containsKey(id)){
            count=voteType==VoteType.UPVOTE?2:-2;
        }else{
            count=voteType==VoteType.UPVOTE?1:-1;
        }

        voteCount.addAndGet(count);

        EventType cur= EventType.UPVOTE_ANSWER;
        if(this instanceof Answer){
            cur=voteType==VoteType.UPVOTE?EventType.UPVOTE_ANSWER:EventType.DOWNVOTE_ANSWER;
        }else{
            cur=voteType==VoteType.UPVOTE?EventType.UPVOTE_QUESTION:EventType.DOWNVOTE_QUESTION;
        }

        notifyObservers(new Event(user,this,cur));
    }
}
