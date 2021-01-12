package com.rao.controller;

import java.io.IOException;

import com.rao.domain.ConvertParams;
import com.rao.domain.DisplayNetWorth;
import com.rao.domain.NetWorthParams;
import com.rao.service.CurrencyService;
import com.rao.service.NetWorthService;

import org.json.JSONException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NetWorthController {

	NetWorthService netWorthService = new NetWorthService();
	CurrencyService currencyService = new CurrencyService();

	@GetMapping("/initialize")
	public DisplayNetWorth initialize() { // Initialize state of the application with example net worth data
		return netWorthService.initialize();
	}

	@PostMapping("/netWorth")
	public DisplayNetWorth calculateNetWorth(@RequestBody NetWorthParams params) {
		return netWorthService.calculateNetWorth(params.getAssets(), params.getLiabilities(),
				currencyService.getNetWorthCurrency(params.getCurrencyCode()));
	}

	@PostMapping("/convert")
	public DisplayNetWorth convertNetWorth(@RequestBody ConvertParams params) throws IOException, JSONException {
		return netWorthService.convertCurrency(params.getAssets(), params.getLiabilities(),
				params.getOriginalCurrencyCode(), params.getConvertCurrencyCode());
	}

}
