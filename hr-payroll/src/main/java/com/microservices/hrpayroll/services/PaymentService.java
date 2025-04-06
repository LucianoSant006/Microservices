package com.microservices.hrpayroll.services;

import com.microservices.hrpayroll.entities.Payment;
import com.microservices.hrpayroll.entities.Worker;
import com.microservices.hrpayroll.feignclients.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {


   @Autowired
   private WorkerFeignClient workerFeignClient;

    public Payment getPayment(long workerId, int days){


        Worker worker = workerFeignClient.findById(workerId).getBody();
        return new Payment(worker.getName(), worker.getDailyIncome(),days);
    }
}
