package com.Microservice.Learing.OrderService.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.Microservice.Learing.OrderService.Common.Payment;
import com.Microservice.Learing.OrderService.Common.TransactionRequest;
import com.Microservice.Learing.OrderService.Common.TransactionResponse;
import com.Microservice.Learing.OrderService.Dao.OrderRepository;
import com.Microservice.Learing.OrderService.Entity.OrderDetails;

@Service
public class OrderService {
	@Autowired
	OrderRepository orderRepository;
	@Autowired
	RestTemplate resttemplate;

	public TransactionResponse saveOrder(TransactionRequest transactionRequest) {
		Payment paymentdtls = transactionRequest.getPayment();
		System.out.println(transactionRequest);
		OrderDetails orderDtls = orderRepository.save(transactionRequest.getOrder());
		String status = "";

		paymentdtls.setOrderId(orderDtls.getId());
		paymentdtls.setPrice(orderDtls.getPrice());
		ResponseEntity<Payment> paymentResponse = resttemplate.postForEntity("http://localhost:9001/MauryaApp/payment",
				paymentdtls, Payment.class);
		status = paymentResponse.getBody().getStatus().equals("Success")
				? "Payment Successfull,Your order will soon arrive at ur Door Step"
				: "Payment Failled,Please try again after sometime";

		return new TransactionResponse(orderDtls.getId(), orderDtls.getPrice(),
				paymentResponse.getBody().getTransactionId(), status);
	}

	public List<OrderDetails> getOrders() {
		return orderRepository.findAll();
	}

}
