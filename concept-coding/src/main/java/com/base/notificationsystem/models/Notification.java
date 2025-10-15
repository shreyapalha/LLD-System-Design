package com.base.notificationsystem.models;

import com.base.notificationsystem.enums.NotificationType;

import java.util.UUID;

public class Notification {

    private final String id;
    private final String subject;
    private final String content;
    private final Recipient recipient;
    private final NotificationType notificationType;

    public Notification(NotificationBuilder notificationBuilder){
        this.id= UUID.randomUUID().toString();
        this.subject= notificationBuilder.subject;
        this.content= notificationBuilder.content;
        this.recipient=notificationBuilder.recipient;
        this.notificationType=notificationBuilder.notificationType;
    }

    public String getSubject() {
        return subject;
    }

    public String getContent() {
        return content;
    }

    public Recipient getRecipient() {
        return recipient;
    }

    public String getId() {
        return id;
    }

    public NotificationType getNotificationType() {
        return notificationType;
    }

    public static class NotificationBuilder{
        private  String subject;
        private  String content;
        private  Recipient recipient;
        private  NotificationType notificationType;

        public NotificationBuilder setSubject(String subject){
            this.subject=subject;
            return this;
        }

        public NotificationBuilder setContent(String content){
            this.content=content;
            return this;
        }

        public NotificationBuilder setRecipent(Recipient recipient){
            this.recipient=recipient;
            return this;
        }

        public NotificationBuilder setNotificationType(NotificationType notificationType){
            this.notificationType=notificationType;
            return this;
        }

        public Notification build(){
            return new Notification(this);
        }

    }
}
