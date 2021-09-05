package com.Microservice.Learing.PaymentService.Controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.Microservice.Learing.PaymentService.Entity.Payment;
import com.Microservice.Learing.PaymentService.Service.PaymentService;

@RestController
@RequestMapping("/PayTM")
public class PaymentController {
	@Autowired
	PaymentService paymentService;

	@GetMapping("/payment/{paymentId}")
	public Optional<Payment> getPayment(@PathVariable int paymentId) {

		return paymentService.getPayment(paymentId);
	}

	@PostMapping("/payment")
	public Payment addPayment(@RequestBody Payment payment) {

		Payment paymentdtls = paymentService.addPayment(payment);

		return paymentdtls;
	}

	@GetMapping("/payments")
	public List<Payment> addPayment() {

		return paymentService.getPayment();
	}

}
