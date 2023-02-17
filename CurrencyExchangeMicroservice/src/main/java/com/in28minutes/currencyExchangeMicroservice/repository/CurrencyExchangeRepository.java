package com.in28minutes.currencyExchangeMicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28minutes.currencyExchangeMicroservice.entity.CurrencyExchange;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {

	CurrencyExchange findByFromAndTo(String from, String to);
}
