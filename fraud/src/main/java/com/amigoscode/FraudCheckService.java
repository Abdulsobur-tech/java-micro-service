package com.amigoscode;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FraudCheckService {
    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;


    public boolean isFraudulentCustomer(Integer customerID){
        fraudCheckHistoryRepository.save(
                FraudCheckHistory.builder()
                        .customerId(customerID)
                        .isFraudster(false)
                        .createdAt(LocalDateTime.now())
                        .build()
        );
        return false;
    }
}
