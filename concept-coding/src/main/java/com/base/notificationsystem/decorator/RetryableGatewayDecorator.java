package com.base.notificationsystem.decorator;

import com.base.notificationsystem.enums.NotificationType;
import com.base.notificationsystem.interfaces.NotificationGateway;
import com.base.notificationsystem.models.Notification;

public class RetryableGatewayDecorator implements NotificationGateway{
    private final NotificationGateway wrappedGateway;
    private final int maxRetries;
    private final long waitTime;

    public RetryableGatewayDecorator(NotificationGateway notificationGateway,int maxRetry,int waitTime){
        this.wrappedGateway=notificationGateway;
        this.maxRetries=maxRetry;
        this.waitTime=waitTime;
    }

    @Override
    public void sendNotification(Notification notification) throws Exception {
        int attempt = 0;
        while (attempt < maxRetries) {
            try {
                wrappedGateway.sendNotification(notification);
                return; // Success
            } catch (Exception e) {
                attempt++;
                System.out.println("Error: Attempt " + attempt + " failed for notification " + notification.getId() + ". Retrying...");
                if (attempt >= maxRetries) {
                    System.out.println(e.getMessage());
                    throw new Exception("Failed to send notification after " + maxRetries + " attempts.", e);
                }
                Thread.sleep(waitTime);
            }
        }
    }
}
