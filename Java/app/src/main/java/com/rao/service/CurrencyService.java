package com.rao.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.rao.domain.NetWorthCurrency;
import com.ritaja.xchangerate.util.Currency;

import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONML;
import org.json.JSONObject;
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

    public double getExchangeRate(String originalCurrencyCode, String convertCurrencyCode)
            throws IOException, JSONException {
        HttpClientBuilder builder = HttpClientBuilder.create();
        try (CloseableHttpClient httpclient = builder.build()) {
            HttpGet httpGet = new HttpGet("https://v6.exchangerate-api.com/v6/0140e23302e973ac4a07a79a/latest/" + originalCurrencyCode);
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            String responseBody = httpclient.execute(httpGet, responseHandler);
            JSONObject result = new JSONObject(responseBody);
            JSONObject conversionRates = result.getJSONObject("conversion_rates");
            double conversionRate = Double.parseDouble(conversionRates.getString(convertCurrencyCode));
            return conversionRate;
        }
    }
}
