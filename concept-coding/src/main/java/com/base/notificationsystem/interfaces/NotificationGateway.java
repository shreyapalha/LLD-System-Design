package com.base.notificationsystem.interfaces;

import com.base.notificationsystem.models.Notification;

public interface NotificationGateway {
    void sendNotification(Notification notification) throws Exception;
}
