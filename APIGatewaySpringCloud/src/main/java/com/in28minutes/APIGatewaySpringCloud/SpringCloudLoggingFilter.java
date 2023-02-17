package com.in28minutes.APIGatewaySpringCloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class SpringCloudLoggingFilter implements GlobalFilter
{	
	private Logger logger = LoggerFactory.getLogger(SpringCloudLoggingFilter.class);

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, 
			GatewayFilterChain chain) {
		
		logger.info("Path of the request recieved -> {}",exchange.getRequest().getPath());
		
		return chain.filter(exchange);
	}

}
