package com.in28minutes.APIGatewaySpringCloud;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration 
{
	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder)
	{
		return builder.routes()
				.route(p -> p.path("/get")
				     .filters(f->f.addRequestHeader("MyHeader","MyURI"))
				     .uri("http://httpbin.org:80"))
				
				.route(p->p.path("/currency-exchange/**")
					 .uri("lb://currency-exchange"))
				
				.route(p->p.path("/currency-conversion/**")
					 .uri("lb://currency-conversion"))
				
				.route(p->p.path("/currency-conversion-feign/**")
					 .uri("lb://currency-conversion"))
				.build();
	}
	
	/*
Custom Routes

- http://localhost:8765/currency-exchange/from/USD/to/INR

- http://localhost:8765/currency-conversion/from/USD/to/INR/quantity/10

- http://localhost:8765/currency-conversion-feign/from/USD/to/INR/quantity/10

- http://localhost:8765/currency-conversion-new/from/USD/to/INR/quantity/10 
	 */
	
	
}
