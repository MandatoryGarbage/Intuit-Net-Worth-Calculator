package com.rao.domain;

import com.ritaja.xchangerate.util.Currency;

public class NetWorthCurrency {
    private Currency currencyCode;
    private String currencySymbol;

    public NetWorthCurrency(Currency currency, String currencySymbol) {
        this.setCurrencyCode(currency);
        this.setCurrencySymbol(currencySymbol);
    }

    public Currency getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(Currency currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencySymbol() {
        return currencySymbol;
    }

    public void setCurrencySymbol(String currencySymbol) {
        this.currencySymbol = currencySymbol;
    }
}
