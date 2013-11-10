package model;

import java.util.Calendar;

public class ExchangeRate {

    private final Number rate;
    private final Currency fromCurrency;
    private final Currency toCurrency;
    private final Calendar date;

    public ExchangeRate(Number rate, Currency fromCurrency, Currency toCurrency, Calendar date) {
        this.rate = rate;
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.date = date;
    }
    
    public Number getRate() {
        return rate;
    }

    public Currency getFromCurrency() {
        return fromCurrency;
    }

    public Currency getToCurrency() {
        return toCurrency;
    }

    public Calendar getDate() {
        return date;
    }
    
    

}
