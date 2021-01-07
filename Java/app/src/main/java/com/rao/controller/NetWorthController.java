package com.rao.controller;

import java.util.ArrayList;

import com.rao.domain.Asset;
import com.rao.domain.Liability;
import com.rao.domain.NetWorth;
import com.rao.service.NetWorthService;
import com.ritaja.xchangerate.util.Currency;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/netWorth")
public class NetWorthController {

	NetWorthService netWorthService = new NetWorthService();

	@GetMapping("/")
	public NetWorth initialize() { // Initialize state of the application with example net worth data
		ArrayList<Asset> assets = new ArrayList<>();
		ArrayList<Liability> liabilities = new ArrayList<>();
		Currency currency = Currency.CAD;
		return calculateNetWorth(assets, liabilities, currency);
	}

	@PostMapping("/")
	public NetWorth calculateNetWorth(ArrayList<Asset> assets, ArrayList<Liability> liabilities, Currency currency) {
		return netWorthService.calculateNetWorth(assets, liabilities, currency);
	}

}
