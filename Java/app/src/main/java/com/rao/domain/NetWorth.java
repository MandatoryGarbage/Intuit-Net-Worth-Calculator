package com.rao.domain;

import java.util.ArrayList;

import com.ritaja.xchangerate.util.Currency;

public class NetWorth {

    private float netWorth;
    private Currency currency;
    private ArrayList<Asset> assets;
    private ArrayList<Liability> liabilities;
    private float totalAssets;
    private float totalLiabilities;

    public NetWorth(float netWorth, Currency currency, ArrayList<Asset> assets, ArrayList<Liability> liabilities,
            float totalAssets, float totalLiabilities) {
        this.netWorth = netWorth;
        this.currency = currency;
        this.assets = assets;
        this.liabilities = liabilities;
        this.totalAssets = totalAssets;
        this.totalLiabilities = totalLiabilities;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public float getTotalLiabilities() {
        return totalLiabilities;
    }

    public void setTotalLiabilities(float totalLiabilities) {
        this.totalLiabilities = totalLiabilities;
    }

    public float getTotalAssets() {
        return totalAssets;
    }

    public void setTotalAssets(float totalAssets) {
        this.totalAssets = totalAssets;
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

    public float getNetWorth() {
        return netWorth;
    }

    public void setNetWorth(float netWorth) {
        this.netWorth = netWorth;
    }

   


    

}
