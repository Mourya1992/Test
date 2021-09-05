package com.Microservice.Learing.SpringCloudGateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudGatewayConfig {
	@Bean
	public RouteLocator customRoutes(RouteLocatorBuilder builder) {

		return builder.routes()
				.route(p -> p.path("/get").filters(f -> f.addRequestHeader("My.Header", "1234"))
						.uri("http://httpbin.org:80"))
				.route(p -> p.path("/orderApi/**").uri("lb://ORDER-SERVICE"))
				.route(p -> p.path("/PayTM/**").uri("lb://PAYMENT-SERVICE")).build();
	}

}
