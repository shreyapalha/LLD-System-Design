package com.base.pubsub.subscriber;


import com.base.pubsub.entities.Message;

public interface Subscriber {
    String getId();
    void consume(Message message);
}

class AlertSubscriber implements Subscriber{
    private final String id;

    public AlertSubscriber(String id){
        this.id=id;
    }


    @Override
    public String getId() {
        return id;
    }

    @Override
    public void consume(Message message) {
        //do something
    }
}

class NewsSubscriber implements Subscriber{
    private final String id;

    public NewsSubscriber(String id){
        this.id=id;
    }


    @Override
    public String getId() {
        return id;
    }

    @Override
    public void consume(Message message) {
        //do something
    }
}
