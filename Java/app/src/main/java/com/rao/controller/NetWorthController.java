package com.rao.controller;

import java.util.ArrayList;

import com.rao.domain.Asset;
import com.rao.domain.Liability;
import com.rao.domain.NetWorth;
import com.rao.domain.NetWorthCurrency;
import com.rao.service.CurrencyService;
import com.rao.service.NetWorthService;
import com.ritaja.xchangerate.util.Currency;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NetWorthController {

	NetWorthService netWorthService = new NetWorthService();
	CurrencyService currencyService = new CurrencyService();

	@GetMapping("/netWorth")
	public NetWorth initialize() { // Initialize state of the application with example net worth data
		
		return netWorthService.initialize();
	}

	@PostMapping("/netWorth")
	public NetWorth calculateNetWorth(ArrayList<Asset> assets, ArrayList<Liability> liabilities, String currencyCode) {
		System.out.println(assets.size());
		System.out.println(liabilities.size());
		System.out.println(currencyCode);
		return netWorthService.calculateNetWorth(assets, liabilities, currencyService.getNetWorthCurrency(currencyCode));
	}

}
