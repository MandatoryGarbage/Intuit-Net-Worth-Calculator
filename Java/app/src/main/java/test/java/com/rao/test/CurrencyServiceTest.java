package test.java.com.rao.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.rao.service.CurrencyService;
import com.ritaja.xchangerate.util.Currency;

import org.junit.Before;
import org.junit.Test;

public class CurrencyServiceTest {

    CurrencyService currencyService;

    @Before
    public void setUp() {
        currencyService = new CurrencyService();
    }

    @Test
    public void shouldInitializeWithMap() {
        // Map should exist
        assertNotNull(currencyService.currencyMap);

        // Map should be 10 items long
        assertEquals(currencyService.currencyMap.size(), 10);
    }

    @Test
    public void shouldReturnCurrency() {
        // Test all 10 currency codes
        assertEquals(currencyService.getNetWorthCurrency("CAD").getCurrencyCode(), Currency.CAD);
        assertEquals(currencyService.getNetWorthCurrency("CAD").getCurrencySymbol(), "$");
        assertEquals(currencyService.getNetWorthCurrency("USD").getCurrencyCode(), Currency.USD);
        assertEquals(currencyService.getNetWorthCurrency("USD").getCurrencySymbol(), "$");
        assertEquals(currencyService.getNetWorthCurrency("GBP").getCurrencyCode(), Currency.GBP);
        assertEquals(currencyService.getNetWorthCurrency("GBP").getCurrencySymbol(), "£");
        assertEquals(currencyService.getNetWorthCurrency("JPY").getCurrencyCode(), Currency.JPY);
        assertEquals(currencyService.getNetWorthCurrency("JPY").getCurrencySymbol(), "¥");
        assertEquals(currencyService.getNetWorthCurrency("EUR").getCurrencyCode(), Currency.EUR);
        assertEquals(currencyService.getNetWorthCurrency("EUR").getCurrencySymbol(), "€");
        assertEquals(currencyService.getNetWorthCurrency("DKK").getCurrencyCode(), Currency.DKK);
        assertEquals(currencyService.getNetWorthCurrency("DKK").getCurrencySymbol(), "kr");
        assertEquals(currencyService.getNetWorthCurrency("HKD").getCurrencyCode(), Currency.HKD);
        assertEquals(currencyService.getNetWorthCurrency("HKD").getCurrencySymbol(), "$");
        assertEquals(currencyService.getNetWorthCurrency("KES").getCurrencyCode(), Currency.KES);
        assertEquals(currencyService.getNetWorthCurrency("KES").getCurrencySymbol(), "KSh");
        assertEquals(currencyService.getNetWorthCurrency("KRW").getCurrencyCode(), Currency.KRW);
        assertEquals(currencyService.getNetWorthCurrency("KRW").getCurrencySymbol(), "₩");
        assertEquals(currencyService.getNetWorthCurrency("SEK").getCurrencyCode(), Currency.SEK);
        assertEquals(currencyService.getNetWorthCurrency("SEK").getCurrencySymbol(), "kr");
    }

    @Test
    public void shouldListCurrencies() {
        assertFalse(currencyService.listCurrencies().isEmpty());
    }

    @Test
    public void shouldGetExchangeRates()  {
        // Test a few currency exchanges
        try {
            assertNotNull(currencyService.getExchangeRate("CAD", "USD"));
            assertNotNull(currencyService.getExchangeRate("KRW", "JPY"));
            assertNotNull(currencyService.getExchangeRate("SEK", "EUR"));
            assertNotNull(currencyService.getExchangeRate("USD", "GBP"));
            assertNotNull(currencyService.getExchangeRate("DKK", "CAD"));
        } catch (Exception e) {
            e.printStackTrace();
        }
       
        // Test a failed currency exchanges
        try {
            currencyService.getExchangeRate("not real", "failure");
        } catch (Exception e) {
            assertTrue(true);
        }
    }
}
