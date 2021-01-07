package com.rao.controller;

import com.rao.domain.NetWorth;
import com.rao.service.NetWorthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class NetWorthController {
	
	@Autowired
	NetWorthService netWorthService;

	@GetMapping("/netWorth")
	public String initialize() {
		return "Greetings from Spring Boot!";
	}

	@PostMapping("/netWorth")
	public NetWorth calculateNetWorth() {
		// return netWorthService.calculateNetWorth(assets, liabilities, currency);
		return null;
	}

}
