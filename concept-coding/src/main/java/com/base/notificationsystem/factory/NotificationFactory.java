package com.base.notificationsystem.factory;

import com.base.notificationsystem.enums.NotificationType;
import com.base.notificationsystem.interfaces.NotificationGateway;
import com.base.notificationsystem.models.EmailNotificationGateway;
import com.base.notificationsystem.models.Notification;
import com.base.notificationsystem.models.SMSNotificationGateway;

import java.util.HashMap;
import java.util.Map;

public class NotificationFactory {
    private static final Map<NotificationType, NotificationGateway> map=new HashMap<>();

    public static NotificationGateway getGateway(NotificationType type){
        if(map.containsKey(type)){
            return map.get(type);
        }

        NotificationGateway gateway=null;
        switch(type){
            case SMS:
                gateway=new SMSNotificationGateway();
                break;
            case EMAIL:
                gateway=new EmailNotificationGateway();
                break;


        }
        map.put(type,gateway);
        return gateway;
    }

}
