package com.rao.controller;

import java.io.IOException;

import com.rao.domain.ConvertParams;
import com.rao.domain.NetWorth;
import com.rao.domain.NetWorthParams;
import com.rao.service.CurrencyService;
import com.rao.service.NetWorthService;
import com.ritaja.xchangerate.api.CurrencyNotSupportedException;
import com.ritaja.xchangerate.endpoint.EndpointException;
import com.ritaja.xchangerate.service.ServiceException;
import com.ritaja.xchangerate.storage.StorageException;

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
	public NetWorth initialize() { // Initialize state of the application with example net worth data
		return netWorthService.initialize();
	}

	@PostMapping("/netWorth")
	public NetWorth calculateNetWorth(@RequestBody NetWorthParams params) {
		return netWorthService.calculateNetWorth(params.getAssets(), params.getLiabilities(),
				currencyService.getNetWorthCurrency(params.getCurrencyCode()));
	}

	@PostMapping("/convert")
	public NetWorth convertNetWorth(@RequestBody ConvertParams params) throws IOException, JSONException {
		return netWorthService.convertCurrency(params.getAssets(), params.getLiabilities(),
				params.getOriginalCurrencyCode(), params.getConvertCurrencyCode());
	}

}
