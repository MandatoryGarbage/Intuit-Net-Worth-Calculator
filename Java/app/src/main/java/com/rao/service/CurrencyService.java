package com.rao.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.rao.domain.NetWorthCurrency;
import com.ritaja.xchangerate.util.Currency;

import org.springframework.stereotype.Component;

@Component
public class CurrencyService {

    private HashMap<String, NetWorthCurrency> currencyMap;

    public CurrencyService() {
        currencyMap = new HashMap<>();
        currencyMap.put("CAD", new NetWorthCurrency(Currency.CAD, "$"));
        currencyMap.put("USD", new NetWorthCurrency(Currency.USD, "$"));
        currencyMap.put("GBP", new NetWorthCurrency(Currency.GBP, "£"));
        currencyMap.put("JPY", new NetWorthCurrency(Currency.JPY, "¥"));
        currencyMap.put("EUR", new NetWorthCurrency(Currency.EUR, "€"));
        currencyMap.put("DKK", new NetWorthCurrency(Currency.DKK, "kr"));
        currencyMap.put("HKD", new NetWorthCurrency(Currency.HKD, "$"));
        currencyMap.put("KES", new NetWorthCurrency(Currency.KES, "KSh"));
        currencyMap.put("KRW", new NetWorthCurrency(Currency.KRW, "₩"));
        currencyMap.put("SEK", new NetWorthCurrency(Currency.SEK, "kr"));
    }

    public ArrayList<NetWorthCurrency> listCurrencies() {
        ArrayList<NetWorthCurrency> currencies = new ArrayList<>();
        for (NetWorthCurrency currency : currencyMap.values()) {
            currencies.add(currency);
        }
        return currencies;
    }

    public NetWorthCurrency getNetWorthCurrency(String currencyCode) {
        return currencyMap.get(currencyCode);
    }
}
