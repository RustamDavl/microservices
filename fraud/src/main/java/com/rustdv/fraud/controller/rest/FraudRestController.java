package com.rustdv.fraud.controller.rest;

import com.rustdv.clients.fraud.dto.FraudReadDto;

import com.rustdv.fraud.service.FraudService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/fraud")
@RequiredArgsConstructor
@Slf4j
public class FraudRestController {


    private final FraudService fraudService;


    @GetMapping("/{customerId}")
    public FraudReadDto create(@PathVariable("customerId") Integer customerId) {

        var isFraudulent = fraudService.isFraudulentCustomer(customerId);

        log.info("fraud check request for customer {}", customerId);

        return FraudReadDto.builder()
                .isFraudulent(isFraudulent)
                .build();

    }
}
