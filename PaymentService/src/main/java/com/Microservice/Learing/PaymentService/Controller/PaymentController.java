package com.Microservice.Learing.PaymentService.Controller;

import java.net.URI;
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
@RequestMapping("/MauryaApp")
public class PaymentController {
	@Autowired
	PaymentService paymentService;

	@GetMapping("/payment/{paymentId}")
	public Optional<Payment> getPayment(@PathVariable int paymentId) {

		return paymentService.getPayment(paymentId);
	}

	@PostMapping("/payment")
	public ResponseEntity<Object> addPayment(@RequestBody Payment payment) {

		Payment paymentdtls = paymentService.addPayment(payment);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(paymentdtls.getId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}

}
