package com.rustdv.fraud.service;

import com.rustdv.fraud.entity.Fraud;
import com.rustdv.fraud.repository.FraudRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;


@Service
@Transactional
@RequiredArgsConstructor
public class FraudService {


    private final FraudRepository fraudRepository;

    public boolean isFraudulentCustomer(Integer customerId) {

        var fraudToSave = Fraud.builder()
                .customerId(customerId)
                .isFraudster(false)
                .createdAt(LocalDateTime.now())
                .build();

        fraudRepository.save(fraudToSave);

        return false;
    }
}
