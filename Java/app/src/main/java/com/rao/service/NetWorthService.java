package com.rao.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

import com.rao.domain.Asset;
import com.rao.domain.DisplayAsset;
import com.rao.domain.DisplayLiability;
import com.rao.domain.Liability;
import com.rao.domain.DisplayNetWorth;
import com.rao.domain.NetWorthCurrency;
import com.ritaja.xchangerate.util.Currency;

import org.json.JSONException;
import org.springframework.stereotype.Component;

@Component
public class NetWorthService {

    private CurrencyService currencyService;
    private DecimalFormat decimalFormat;

    public NetWorthService() {
        currencyService = new CurrencyService();
        decimalFormat = new DecimalFormat("0.00");
    }

    public DisplayNetWorth initialize() {
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

    public DisplayNetWorth calculateNetWorth(ArrayList<Asset> assets, ArrayList<Liability> liabilities,
            NetWorthCurrency currency) {
        double totalAssets = 0.00;
        double totalLiabilities = 0.00;
        double netWorth = 0.00;
        ArrayList<DisplayAsset> displayAssets = new ArrayList<>();
        for (Asset asset : assets) {
            DisplayAsset displayAsset = new DisplayAsset(asset.getCategory(), asset.getLineItem(), decimalFormat.format(asset.getAmount()));
            displayAssets.add(displayAsset);
            totalAssets += asset.getAmount();
        }
        totalAssets = new BigDecimal(totalAssets).setScale(2, RoundingMode.FLOOR).doubleValue();
        ArrayList<DisplayLiability> displayLiabilities = new ArrayList<>();
        for (Liability liability : liabilities) {
            DisplayLiability displayLiability = new DisplayLiability(liability.getCategory(), liability.getLineItem(), decimalFormat.format(liability.getMonthlyPayment()), decimalFormat.format(liability.getAmount()));
            displayLiabilities.add(displayLiability);
            totalLiabilities += liability.getAmount();
        }
        totalLiabilities = new BigDecimal(totalLiabilities).setScale(2, RoundingMode.FLOOR).doubleValue();
        netWorth = new BigDecimal(totalAssets - totalLiabilities).setScale(2, RoundingMode.FLOOR).doubleValue();
        return new DisplayNetWorth(decimalFormat.format(netWorth), currency, displayAssets, displayLiabilities, decimalFormat.format(totalAssets),
                decimalFormat.format(totalLiabilities));
    }

    public DisplayNetWorth convertCurrency(ArrayList<Asset> assets, ArrayList<Liability> liabilities,
            String originalCurrencyCode, String convertCurrencyCode) throws IOException, JSONException {
        double exchangeRate = currencyService.getExchangeRate(originalCurrencyCode, convertCurrencyCode);
        for (Asset asset : assets) {
            asset.setAmount(
                    new BigDecimal(asset.getAmount() * exchangeRate).setScale(2, RoundingMode.FLOOR).doubleValue());
        }
        for (Liability liability : liabilities) {
            liability.setAmount(
                    new BigDecimal(liability.getAmount() * exchangeRate).setScale(2, RoundingMode.FLOOR).doubleValue());
        }
        return calculateNetWorth(assets, liabilities, currencyService.getNetWorthCurrency(convertCurrencyCode));
    }
}
