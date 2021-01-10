package com.rao.controller;

import java.util.ArrayList;

import com.rao.domain.NetWorthCurrency;
import com.rao.service.CurrencyService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyController {

	CurrencyService currencyService = new CurrencyService();

	@GetMapping("/currency")
	public ArrayList<NetWorthCurrency> initialize() {
		return currencyService.listCurrencies();
	}

}