package com.rao.domain;

import java.util.ArrayList;

public class DisplayNetWorth {

    private String netWorth;
    private NetWorthCurrency currency;
    private ArrayList<DisplayAsset> assets;
    private ArrayList<DisplayLiability> liabilities;
    private String totalAssets;
    private String totalLiabilities;

    public DisplayNetWorth(String netWorth, NetWorthCurrency currency, ArrayList<DisplayAsset> assets,
            ArrayList<DisplayLiability> liabilities, String totalAssets, String totalLiabilities) {
        this.setNetWorth(netWorth);
        this.setCurrency(currency);
        this.setAssets(assets);
        this.setLiabilities(liabilities);
        this.setTotalAssets(totalAssets);
        this.setTotalLiabilities(totalLiabilities);
    }

    public String getTotalLiabilities() {
        return totalLiabilities;
    }

    public void setTotalLiabilities(String totalLiabilities) {
        this.totalLiabilities = totalLiabilities;
    }

    public String getTotalAssets() {
        return totalAssets;
    }

    public void setTotalAssets(String totalAssets) {
        this.totalAssets = totalAssets;
    }

    public ArrayList<DisplayLiability> getLiabilities() {
        return liabilities;
    }

    public void setLiabilities(ArrayList<DisplayLiability> liabilities) {
        this.liabilities = liabilities;
    }

    public ArrayList<DisplayAsset> getAssets() {
        return assets;
    }

    public void setAssets(ArrayList<DisplayAsset> assets) {
        this.assets = assets;
    }

    public NetWorthCurrency getCurrency() {
        return currency;
    }

    public void setCurrency(NetWorthCurrency currency) {
        this.currency = currency;
    }

    public String getNetWorth() {
        return netWorth;
    }

    public void setNetWorth(String netWorth) {
        this.netWorth = netWorth;
    }

}
