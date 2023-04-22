package com.rustdv.clients.notification.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotificationRequest {

    private Integer toCustomerId;
    private String toCustomerName;
    private String message;
}
