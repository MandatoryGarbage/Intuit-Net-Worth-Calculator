package com.rao.domain;

public class ConvertParams {
    private NetWorth netWorth;
    private String currencyCode;

    public ConvertParams(NetWorth netWorth, String currencyCode) {
        this.setNetWorth(netWorth);
        this.setCurrencyCode(currencyCode);
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public NetWorth getNetWorth() {
        return netWorth;
    }

    public void setNetWorth(NetWorth netWorth) {
        this.netWorth = netWorth;
    }


    
}
