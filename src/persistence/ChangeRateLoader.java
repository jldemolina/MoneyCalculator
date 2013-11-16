package persistence;

import java.util.Calendar;
import model.Currency;
import model.ExchangeRate;

public interface ChangeRateLoader {
    
    public ExchangeRate load(Currency fromCurrency, Currency toCurrency, Calendar date);
    public ExchangeRate load(Currency fromCurrency, Currency toCurrency);

}
