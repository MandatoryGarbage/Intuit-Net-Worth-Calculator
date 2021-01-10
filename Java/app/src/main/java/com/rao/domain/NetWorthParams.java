package com.rao.domain;

import java.util.ArrayList;

public class NetWorthParams {
    private ArrayList<Asset> assets;
    private ArrayList<Liability> liabilities;
    private String currencyCode;

    public NetWorthParams(ArrayList<Asset> assets, ArrayList<Liability> liabilities, String currencyCode) {
        this.setAssets(assets);
        this.setLiabilities(liabilities);
        this.setCurrencyCode(currencyCode);
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public ArrayList<Liability> getLiabilities() {
        return liabilities;
    }

    public void setLiabilities(ArrayList<Liability> liabilities) {
        this.liabilities = liabilities;
    }

    public ArrayList<Asset> getAssets() {
        return assets;
    }

    public void setAssets(ArrayList<Asset> assets) {
        this.assets = assets;
    }
}