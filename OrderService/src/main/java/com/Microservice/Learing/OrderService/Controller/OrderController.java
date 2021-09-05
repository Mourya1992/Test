package com.Microservice.Learing.OrderService.Controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.Microservice.Learing.OrderService.Common.Payment;
import com.Microservice.Learing.OrderService.Common.TransactionRequest;
import com.Microservice.Learing.OrderService.Common.TransactionResponse;
import com.Microservice.Learing.OrderService.Entity.OrderDetails;
import com.Microservice.Learing.OrderService.Service.OrderService;

@RestController
@RequestMapping("/MauryaApp")
public class OrderController {
	@Autowired
	OrderService orderService;

	@GetMapping("/orders")
	public List<OrderDetails> getOrderDetails() {

		return orderService.getOrders();
	}

	@PostMapping("/placeorder")
	public ResponseEntity<TransactionResponse> saveOrderDetails(@RequestBody TransactionRequest transactionRequest) {
		TransactionResponse transactionResponse = null;
		if (transactionRequest != null) {
			transactionResponse = orderService.saveOrder(transactionRequest);
		}
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(transactionResponse.getOrderId()).toUri();

		return ResponseEntity.created(location).body(transactionResponse);

	}

}
