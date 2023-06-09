package com.rustdv.customer.controller;

import com.rustdv.customer.entity.Customer;
import com.rustdv.customer.entity.CustomerRequest;
import com.rustdv.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<Customer> registerCustomer(@RequestBody CustomerRequest customerRequest) {

        log.info("new customer registration {}", customerRequest);

        return ResponseEntity.ok(customerService.create(customerRequest));
    }
}

