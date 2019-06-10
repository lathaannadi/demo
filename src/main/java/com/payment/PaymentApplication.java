package com.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@SpringBootApplication
public class PaymentApplication implements CommandLineRunner {
	private static final Logger log = LoggerFactory.getLogger(PaymentApplication.class);

	@Autowired
	private PaymentRepository paymentRepository;

	@Autowired
	private PaymentService paymentService;

	@Override
	public void run(String... args) throws Exception {
		log.info("Application start...");
		paymentService.batchPaymentObjects();


		List<Payment> paymentList = paymentRepository.findTop10ByOrderById();
		paymentList.stream().forEach(payment->log.info(payment.toString()));

		log.info("Payment Count=================="+paymentRepository.count());



	}

	public static void main(String[] args) {
		SpringApplication.run(PaymentApplication.class);
	}
}
