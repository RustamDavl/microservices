package com.rustdv.customer.service;

import com.rustdv.clients.fraud.FraudClient;
import com.rustdv.clients.fraud.dto.FraudReadDto;

import com.rustdv.clients.notification.NotificationClient;
import com.rustdv.clients.notification.dto.NotificationRequest;
import com.rustdv.customer.entity.Customer;
import com.rustdv.customer.entity.CustomerRequest;
import com.rustdv.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    private final RestTemplate restTemplate;

    private final NotificationClient notificationClient;

    private final FraudClient fraudClient;

    public Customer create(CustomerRequest customerRequest) {

        var customer = Customer.builder()
                .firstName(customerRequest.getFirstName())
                .lastName(customerRequest.getLastName())
                .email(customerRequest.getEmail())
                .build();
        customerRepository.saveAndFlush(customer);



        FraudReadDto fraudReadDto = fraudClient.create(customer.getId());

        assert fraudReadDto != null;
        if (fraudReadDto.getIsFraudulent()) {
            throw new IllegalStateException();
        }

        // TODO: 07.04.2023 send notification


        notificationClient.sendNotification(
                NotificationRequest.builder()
                        .toCustomerId(customer.getId())
                        .toCustomerName(customer.getEmail())
                        .message(
                                String.format("Hi %s, the greeting from RustDv ...",
                                        customer.getFirstName())
                        )
                        .build()
        );
        return customer;
    }


}
