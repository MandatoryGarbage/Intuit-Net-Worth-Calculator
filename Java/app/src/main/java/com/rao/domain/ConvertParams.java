package com.rao.domain;

import java.util.ArrayList;

public class ConvertParams {
    private ArrayList<Asset> assets;
    private ArrayList<Liability> liabilities;
    private String originalCurrencyCode;
    private String convertCurrencyCode;

    public ConvertParams(ArrayList<Asset> assets, ArrayList<Liability> liabilities, String originalCurrencyCode,
            String convertCurrencyCode) {
        this.setAssets(assets);
        this.setLiabilities(liabilities);
        this.setOriginalCurrencyCode(originalCurrencyCode);
        this.setConvertCurrencyCode(convertCurrencyCode);
    }

    public String getConvertCurrencyCode() {
        return convertCurrencyCode;
    }

    public void setConvertCurrencyCode(String convertCurrencyCode) {
        this.convertCurrencyCode = convertCurrencyCode;
    }

    public String getOriginalCurrencyCode() {
        return originalCurrencyCode;
    }

    public void setOriginalCurrencyCode(String originalCurrencyCode) {
        this.originalCurrencyCode = originalCurrencyCode;
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
