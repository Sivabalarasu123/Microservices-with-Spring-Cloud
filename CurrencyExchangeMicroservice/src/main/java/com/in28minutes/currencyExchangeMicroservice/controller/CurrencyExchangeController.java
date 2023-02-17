package com.in28minutes.currencyExchangeMicroservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.currencyExchangeMicroservice.entity.CurrencyExchange;
import com.in28minutes.currencyExchangeMicroservice.repository.CurrencyExchangeRepository;

@RestController
public class CurrencyExchangeController 
{
	@Autowired
	private org.springframework.core.env.Environment environment;
	
	@Autowired
	private CurrencyExchangeRepository repository;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchangeValue(@PathVariable String from,@PathVariable String to)
	{
		CurrencyExchange currencyExchange = repository.findByFromAndTo(from, to);
		
		if(currencyExchange==null)
		{
			throw new RuntimeException("Unable to find Data for "+ from + " to "+to);
		}
		
		String port = environment.getProperty("local.server.port");
		
		currencyExchange.setEnvironment(port);
		
		return currencyExchange;
	}
}
