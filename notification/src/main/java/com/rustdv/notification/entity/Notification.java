package com.rustdv.notification.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "to_customer_id")
    private Integer toCustomerId;

    @Column(name = "to_customer_email")
    private String toCustomerEmail;

    private String sender;

    private String message;

    @Column(name = "sent_at")
    private LocalDateTime sentAt;


}
