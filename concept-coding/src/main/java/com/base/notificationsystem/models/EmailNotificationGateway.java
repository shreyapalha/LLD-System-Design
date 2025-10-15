package com.base.notificationsystem.models;

import com.base.notificationsystem.interfaces.NotificationGateway;

public class EmailNotificationGateway implements NotificationGateway {
    @Override
    public void sendNotification(Notification notification) {
        //logic to send notification via email
    }
}
