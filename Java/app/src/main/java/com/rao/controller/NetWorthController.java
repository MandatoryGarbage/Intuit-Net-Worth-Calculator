package com.rao.controller;

import java.util.ArrayList;

import com.rao.domain.Asset;
import com.rao.domain.Liability;
import com.rao.domain.NetWorth;
import com.rao.domain.NetWorthCurrency;
import com.rao.service.NetWorthService;
import com.ritaja.xchangerate.util.Currency;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NetWorthController {

	NetWorthService netWorthService = new NetWorthService();

	@GetMapping("/netWorth")
	public NetWorth initialize() { // Initialize state of the application with example net worth data
		ArrayList<Asset> assets = new ArrayList<>();
		assets.add(new Asset(1, "Chequing", 2000.00f));
		assets.add(new Asset(1, "Savings for Taxes", 4000.00f));
		assets.add(new Asset(1, "Rainy Day Fund", 506.00f));
		assets.add(new Asset(1, "Savings for Fun", 5000.00f));
		assets.add(new Asset(1, "Savings for Travel", 400.00f));
		assets.add(new Asset(1, "Savings for Personal Development", 200.00f));
		assets.add(new Asset(1, "Investment 1", 5000.00f));
		assets.add(new Asset(1, "Investment 2", 60000.00f));
		assets.add(new Asset(1, "Investment 3", 24000.00f));
		assets.add(new Asset(2, "Primay Home", 455000.00f));
		assets.add(new Asset(2, "Secondary Home", 1564321.00f));
		assets.add(new Asset(2, "Other", 782.43f));
		ArrayList<Liability> liabilities = new ArrayList<>();
		liabilities.add(new Liability(1, "Credit Card 1", 200.00f, 4342.00f));
		liabilities.add(new Liability(1, "Credit Card 2", 150.00f, 322.00f));
		liabilities.add(new Liability(2, "Mortgage 1", 2000.00f, 250999.00f));
		liabilities.add(new Liability(2, "Mortgage 2", 3500.00f, 632634.00f));
		liabilities.add(new Liability(2, "Line of Credit", 500.00f, 10000.00f));
		liabilities.add(new Liability(2, "Investment Loan", 700.00f, 12500.00f));
		NetWorthCurrency netWorthCurrency = new NetWorthCurrency(Currency.CAD, "$");
		return netWorthService.calculateNetWorth(assets, liabilities, netWorthCurrency);
	}

	@PostMapping("/netWorth")
	public NetWorth calculateNetWorth(ArrayList<Asset> assets, ArrayList<Liability> liabilities, NetWorthCurrency netWorthCurrency) {
		System.out.println(assets.size());
		System.out.println(liabilities.size());
		System.out.println(netWorthCurrency.getCurrencyCode());
		return netWorthService.calculateNetWorth(assets, liabilities, netWorthCurrency);
	}

}
