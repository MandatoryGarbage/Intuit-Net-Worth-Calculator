package com.rao.service;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.rao.domain.Asset;
import com.rao.domain.Liability;
import com.rao.domain.NetWorth;
import com.rao.domain.NetWorthCurrency;
import com.ritaja.xchangerate.api.CurrencyConverter;
import com.ritaja.xchangerate.api.CurrencyConverterBuilder;
import com.ritaja.xchangerate.api.CurrencyNotSupportedException;
import com.ritaja.xchangerate.endpoint.EndpointException;
import com.ritaja.xchangerate.service.ServiceException;
import com.ritaja.xchangerate.storage.StorageException;
import com.ritaja.xchangerate.util.Currency;
import com.ritaja.xchangerate.util.Strategy;

import org.json.JSONException;
import org.springframework.stereotype.Component;

@Component
public class NetWorthService {

    private CurrencyConverter converter;

    public NetWorthService() {
        converter = new CurrencyConverterBuilder().strategy(Strategy.YAHOO_FINANCE_FILESTORE).buildConverter();
    }

    public NetWorth initialize() {
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
        return calculateNetWorth(assets, liabilities, netWorthCurrency);
    }

    public NetWorth calculateNetWorth(ArrayList<Asset> assets, ArrayList<Liability> liabilities,
            NetWorthCurrency currency) {
        float totalAssets = 0f;
        float totalLiabilities = 0f;
        for (Asset asset : assets) {
            totalAssets += asset.getAmount();
        }
        for (Liability liability : liabilities) {
            totalLiabilities += liability.getAmount();
        }
        return new NetWorth(totalAssets - totalLiabilities, currency, assets, liabilities, totalAssets,
                totalLiabilities);
    }

    public NetWorth convertCurrency(NetWorth netWorth, NetWorthCurrency currency)
            throws CurrencyNotSupportedException, JSONException, StorageException, EndpointException, ServiceException {
        for (Asset asset : netWorth.getAssets()) {
            asset.setAmount(converter.convertCurrency(new BigDecimal(asset.getAmount()),
                    netWorth.getCurrency().getCurrencyCode(), currency.getCurrencyCode()).floatValue());
        }
        for (Liability liability : netWorth.getLiabilities()) {
            liability.setAmount(converter.convertCurrency(new BigDecimal(liability.getAmount()),
                    netWorth.getCurrency().getCurrencyCode(), currency.getCurrencyCode()).floatValue());
        }
        return calculateNetWorth(netWorth.getAssets(), netWorth.getLiabilities(), currency);
    }
}
