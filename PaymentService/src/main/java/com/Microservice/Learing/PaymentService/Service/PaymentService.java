package com.Microservice.Learing.PaymentService.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Microservice.Learing.PaymentService.Dao.PaymentRepository;
import com.Microservice.Learing.PaymentService.Entity.Payment;

@Service
public class PaymentService {
	@Autowired
	PaymentRepository paymentRepository;

	public Payment addPayment(Payment payment) {
		return paymentRepository.save(payment);
	}

	public Optional<Payment> getPayment(Integer paymentId) {
		return paymentRepository.findById(paymentId);
	}

	public List<Payment> getPayment() {
		return paymentRepository.findAll();
	}
}
