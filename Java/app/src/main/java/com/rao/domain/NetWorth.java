package com.rao.domain;

import java.util.ArrayList;

public class NetWorth {

    private double netWorth;
    private NetWorthCurrency currency;
    private ArrayList<Asset> assets;
    private ArrayList<Liability> liabilities;
    private double totalAssets;
    private double totalLiabilities;

    public NetWorth(double netWorth, NetWorthCurrency currency, ArrayList<Asset> assets,
            ArrayList<Liability> liabilities, double totalAssets, double totalLiabilities) {
        this.netWorth = netWorth;
        this.setCurrency(currency);
        this.assets = assets;
        this.liabilities = liabilities;
        this.totalAssets = totalAssets;
        this.totalLiabilities = totalLiabilities;
    }

    public NetWorthCurrency getCurrency() {
        return currency;
    }

    public void setCurrency(NetWorthCurrency currency) {
        this.currency = currency;
    }

    public double getTotalLiabilities() {
        return totalLiabilities;
    }

    public void setTotalLiabilities(double totalLiabilities) {
        this.totalLiabilities = totalLiabilities;
    }

    public double getTotalAssets() {
        return totalAssets;
    }

    public void setTotalAssets(double totalAssets) {
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

    public double getNetWorth() {
        return netWorth;
    }

    public void setNetWorth(double netWorth) {
        this.netWorth = netWorth;
    }

   


    

}
