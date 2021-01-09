package com.rao.controller;

import java.util.ArrayList;

import com.rao.domain.NetWorthCurrency;
import com.ritaja.xchangerate.util.Currency;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyController {

	@GetMapping("/currency")
	public ArrayList<NetWorthCurrency> initialize() {
		ArrayList<NetWorthCurrency> currencies = new ArrayList<>();
		currencies.add(new NetWorthCurrency(Currency.CAD, "$"));
		currencies.add(new NetWorthCurrency(Currency.USD, "$"));
		currencies.add(new NetWorthCurrency(Currency.GBP, "£"));
		currencies.add(new NetWorthCurrency(Currency.JPY, "¥"));
		currencies.add(new NetWorthCurrency(Currency.EUR, "€"));
		currencies.add(new NetWorthCurrency(Currency.DKK, "kr"));
		currencies.add(new NetWorthCurrency(Currency.HKD, "$"));
		currencies.add(new NetWorthCurrency(Currency.KES, "KSh"));
		currencies.add(new NetWorthCurrency(Currency.KRW, "₩"));
		currencies.add(new NetWorthCurrency(Currency.SEK, "kr"));
		return currencies;
	}

}