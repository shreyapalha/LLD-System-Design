package com.base.notificationsystem.models;

import com.base.notificationsystem.decorator.RetryableGatewayDecorator;
import com.base.notificationsystem.factory.NotificationFactory;
import com.base.notificationsystem.interfaces.NotificationGateway;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NotificationService {
    private final ExecutorService executorService;

    public NotificationService(int poolSize){
        executorService= Executors.newFixedThreadPool(poolSize);
    }


    public void sendNotification(Notification notification){
        executorService.submit(()->{
            NotificationGateway notificationGateway=new RetryableGatewayDecorator(
                    NotificationFactory.getGateway(notification.getNotificationType()),
                            3,1000);
            try {
                notificationGateway.sendNotification(notification);
            } catch (Exception e) {
                System.out.println("Exception while sending notification: " + e);
            }
        });
    }

    public void shutdown(){
        executorService.shutdown();
    }


}
