package com.rustdv.clients.fraud;

import com.rustdv.clients.fraud.dto.FraudReadDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("FRAUD")
public interface FraudClient {

    @GetMapping("/api/v1/fraud/{customerId}")
    FraudReadDto create(@PathVariable("customerId") Integer customerId);
}
