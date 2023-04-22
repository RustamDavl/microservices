package com.rustdv.notification.service;

import com.rustdv.clients.notification.dto.NotificationRequest;
import com.rustdv.notification.entity.Notification;
import com.rustdv.notification.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public void send(NotificationRequest notificationRequest) {

        notificationRepository.save(
                Notification.builder()
                        .toCustomerId(notificationRequest.getToCustomerId())
                        .message(notificationRequest.getMessage())
                        .sentAt(LocalDateTime.now())
                        .toCustomerEmail(notificationRequest.getToCustomerName())
                        .sender("RustDv")
                        .build()

        );
    }


}
