package com.rao.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

import com.rao.domain.Asset;
import com.rao.domain.DisplayNetWorth;
import com.rao.domain.Liability;
import com.rao.domain.NetWorthCurrency;
import com.rao.service.CurrencyService;
import com.rao.service.NetWorthService;
import com.ritaja.xchangerate.util.Currency;

import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NetWorthServiceTest {

    NetWorthService netWorthService;

    @Before
    public void setUp() {
        netWorthService = new NetWorthService();
    }

    @Test
    public void checkInitializationCondiditions() {
        DisplayNetWorth initialConditions = netWorthService.initialize();
        assertFalse(initialConditions.getAssets().isEmpty());
        assertEquals(initialConditions.getAssets().size(), 12);
        assertFalse(initialConditions.getLiabilities().isEmpty());
        assertEquals(initialConditions.getLiabilities().size(), 6);
        assertEquals(initialConditions.getTotalAssets(), "2121209.43");
        assertEquals(initialConditions.getTotalLiabilities(), "910797.00");
        assertEquals(initialConditions.getNetWorth(), "1210412.43");
    }

    @Test
    public void testNetWorthCalculations() {
        NetWorthCurrency currency = new NetWorthCurrency(Currency.CAD, "$");
        ArrayList<Asset> assets = new ArrayList<>();
        ArrayList<Liability> liabilities = new ArrayList<>();
        assets.add(new Asset(1, "test asset", 900.00));
        liabilities.add(new Liability(1, "test liability", 50.00, 400.00));
        DisplayNetWorth testNetWorth = netWorthService.calculateNetWorth(assets, liabilities, currency);
        assertEquals(testNetWorth.getNetWorth(), "500.00");
        assertEquals(testNetWorth.getTotalAssets(), "900.00");
        assertEquals(testNetWorth.getTotalLiabilities(), "400.00");

        // Test Negative net worth
        assets.get(0).setAmount(200.00);
        testNetWorth = netWorthService.calculateNetWorth(assets, liabilities, currency);
        assertEquals(testNetWorth.getNetWorth(), "-200.00");
        assertEquals(testNetWorth.getTotalAssets(), "200.00");
        assertEquals(testNetWorth.getTotalLiabilities(), "400.00");
    }

    @Test
    public void testCurrencyConversion() throws IOException, JSONException {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        String originalCurrencyCode = "CAD";
        String convertCurrencyCode = "USD";
        ArrayList<Asset> assets = new ArrayList<>();
        ArrayList<Liability> liabilities = new ArrayList<>();
        assets.add(new Asset(1, "test asset", 900.00));
        liabilities.add(new Liability(1, "test liability", 50.00, 400.00));
        
        CurrencyService currencyService = new CurrencyService();
        double exchangeRate = currencyService.getExchangeRate(originalCurrencyCode, convertCurrencyCode);
        DisplayNetWorth convertedNetWorth = netWorthService.convertCurrency(assets, liabilities, originalCurrencyCode, convertCurrencyCode);
        String convertedTotalAssets = decimalFormat.format(new BigDecimal(900 * exchangeRate).setScale(2, RoundingMode.FLOOR).doubleValue());
        String convertedTotalLiabilities = decimalFormat.format(new BigDecimal(400 * exchangeRate).setScale(2, RoundingMode.FLOOR).doubleValue());
        String convertedNetWorthTotal = decimalFormat.format(new BigDecimal(500 * exchangeRate).setScale(2, RoundingMode.FLOOR).doubleValue());
        assertEquals(convertedNetWorth.getTotalAssets(), convertedTotalAssets);
        assertEquals(convertedNetWorth.getTotalLiabilities(), convertedTotalLiabilities);
        assertEquals(convertedNetWorth.getNetWorth(), convertedNetWorthTotal);
    }
}
