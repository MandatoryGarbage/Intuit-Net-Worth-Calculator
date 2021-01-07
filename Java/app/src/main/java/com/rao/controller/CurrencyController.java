package com.rao.controller;

import java.util.ArrayList;

import com.ritaja.xchangerate.util.Currency;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyController {

	@GetMapping("/currency")
	public ArrayList<Currency> initialize() {
		ArrayList<Currency> currencies = new ArrayList<>();
		currencies.add(Currency.CAD);
		currencies.add(Currency.USD);
		currencies.add(Currency.GBP);
		currencies.add(Currency.JPY);
		currencies.add(Currency.EUR);
		currencies.add(Currency.DKK);
		currencies.add(Currency.HKD);
		currencies.add(Currency.KES);
		currencies.add(Currency.KRW);
		currencies.add(Currency.SEK);
		return currencies;
	}

}