package com.base.pubsub.entities;


import com.base.pubsub.subscriber.Subscriber;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;

public class Topic {
    private final String name;
    private final Set<Subscriber> subscriberList;
    private final ExecutorService executorService;

    public Topic(String name,ExecutorService executorService){
        this.name=name;
        subscriberList=new HashSet<>();
        this.executorService= executorService;
    }

    public void addSubscriber(Subscriber s){
        subscriberList.add(s);
    }

    public void deleteSubscriber(Subscriber s){
        subscriberList.remove(s);
    }

    public void broadcast(Message m){
        for (Subscriber subscriber : subscriberList) {
            executorService.submit(() -> {
                try {
                    subscriber.consume(m);
                } catch (Exception e) {
                    System.err.println("Error delivering message to subscriber " + subscriber.getId() + ": " + e.getMessage());
                }
            });
        }
    }

}
