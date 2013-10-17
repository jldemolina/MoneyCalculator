package model;

import java.io.IOException;
import java.util.Calendar;
import persistence.ChangeRateDonwloader;

public class ChangeRate {

    private final Number rate;
    private final Currency fromCurrency;
    private final Currency toCurrency;
    private final Calendar date;

    public ChangeRate(Number rate, Currency fromCurrency, Currency toCurrency, Calendar date) {
        this.rate = rate;
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.date = date;
    }
    
    public Number convert() throws IOException {
        double changeValue = new ChangeRateDonwloader(fromCurrency, toCurrency, date).getChangeValue();
        return new Number(0.);
    }

}
