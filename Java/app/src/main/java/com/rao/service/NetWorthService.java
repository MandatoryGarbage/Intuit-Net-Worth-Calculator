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
        assets.add(new Asset(1, "Chequing", 2000.00));
        assets.add(new Asset(1, "Savings for Taxes", 4000.00));
        assets.add(new Asset(1, "Rainy Day Fund", 506.00));
        assets.add(new Asset(1, "Savings for Fun", 5000.00));
        assets.add(new Asset(1, "Savings for Travel", 400.00));
        assets.add(new Asset(1, "Savings for Personal Development", 200.00));
        assets.add(new Asset(1, "Investment 1", 5000.00));
        assets.add(new Asset(1, "Investment 2", 60000.00));
        assets.add(new Asset(1, "Investment 3", 24000.00));
        assets.add(new Asset(2, "Primay Home", 455000.00));
        assets.add(new Asset(2, "Secondary Home", 1564321.00));
        assets.add(new Asset(2, "Other", 782.43));
        ArrayList<Liability> liabilities = new ArrayList<>();
        liabilities.add(new Liability(1, "Credit Card 1", 200.00, 4342.00));
        liabilities.add(new Liability(1, "Credit Card 2", 150.00, 322.00));
        liabilities.add(new Liability(2, "Mortgage 1", 2000.00, 250999.00));
        liabilities.add(new Liability(2, "Mortgage 2", 3500.00, 632634.00));
        liabilities.add(new Liability(2, "Line of Credit", 500.00, 10000.00));
        liabilities.add(new Liability(2, "Investment Loan", 700.00, 12500.00));
        NetWorthCurrency netWorthCurrency = new NetWorthCurrency(Currency.CAD, "$");
        return calculateNetWorth(assets, liabilities, netWorthCurrency);
    }

    public NetWorth calculateNetWorth(ArrayList<Asset> assets, ArrayList<Liability> liabilities,
            NetWorthCurrency currency) {
        double totalAssets = 0.00;
        double totalLiabilities = 0.00;
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
                    netWorth.getCurrency().getCurrencyCode(), currency.getCurrencyCode()).doubleValue());
        }
        for (Liability liability : netWorth.getLiabilities()) {
            liability.setAmount(converter.convertCurrency(new BigDecimal(liability.getAmount()),
                    netWorth.getCurrency().getCurrencyCode(), currency.getCurrencyCode()).doubleValue());
        }
        return calculateNetWorth(netWorth.getAssets(), netWorth.getLiabilities(), currency);
    }
}
