package com.rustdv.clients.notification;

import com.rustdv.clients.notification.dto.NotificationRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("notification")
public interface NotificationClient {

    @PostMapping("/api/v1/notification")
    void sendNotification(NotificationRequest notificationRequest);

}
