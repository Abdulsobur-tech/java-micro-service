package com.amigoscode;

import com.amigoscode.clients.fraud.fraud.FraudCheckResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/fraud-check")
@AllArgsConstructor
@Slf4j
public class FraudController {
    private final FraudCheckService fraudCheckService;

    @GetMapping("{customerID}")
    public FraudCheckResponse isFraudster(@PathVariable("customerID") Integer customerID) {
        boolean isFraudulentCustomer = fraudCheckService
                 .isFraudulentCustomer(customerID);
        log.info("fraud check request for customer {}",customerID);
        return new FraudCheckResponse(isFraudulentCustomer);
    }

}
