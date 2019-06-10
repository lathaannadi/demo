package com.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository playerRepository;

    public void batchPaymentObjects() {
        List<Payment> paymentObjects = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            Random r = new Random();
            int nextPaymentNumber = r.nextInt((1000 - 1) + 1);
            LocalDate date = LocalDate.now().minus(Period.ofDays((ThreadLocalRandom.current().nextInt(365 * 70))));
            paymentObjects.add(new Payment(nextPaymentNumber, 1000.00+nextPaymentNumber, java.sql.Date.valueOf(date)));
        }
       playerRepository.saveAll(paymentObjects);
   }
}
