package com.rao.service;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.rao.domain.Asset;
import com.rao.domain.Liability;
import com.rao.domain.NetWorth;
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
    private CurrencyConverter converter = new CurrencyConverterBuilder().strategy(Strategy.YAHOO_FINANCE_FILESTORE)
            .buildConverter();

    public NetWorth calculateNetWorth(ArrayList<Asset> assets, ArrayList<Liability> liabilities, Currency currency) {
        return null;
    }

    public NetWorth convertCurrency(NetWorth netWorth, Currency currency)
            throws CurrencyNotSupportedException, JSONException, StorageException, EndpointException, ServiceException {
        for (Asset asset: netWorth.getAssets()) {
            asset.setAmount(converter.convertCurrency(new BigDecimal(asset.getAmount()), netWorth.getCurrency(), currency).floatValue());
        }
        for (Liability liability: netWorth.getLiabilities()) {
            liability.setAmount(converter.convertCurrency(new BigDecimal(liability.getAmount()), netWorth.getCurrency(), currency).floatValue());
        }
        return calculateNetWorth(netWorth.getAssets(), netWorth.getLiabilities(), currency);
    }
}
