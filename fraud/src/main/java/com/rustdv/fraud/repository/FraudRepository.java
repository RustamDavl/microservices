package com.rustdv.fraud.repository;

import com.rustdv.fraud.entity.Fraud;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FraudRepository extends JpaRepository<Fraud, Integer> {


}
