package persistence;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Number;
import model.Currency;
import model.ExchangeRate;

public class ChangeRateHTTPLoader implements ChangeRateLoader {

    private static final String URL = "http://currencies.apps.grandtrunk.net/getrate/";

    public ChangeRateHTTPLoader() {
    }

    @Override
    public ExchangeRate load(Currency fromCurrency, Currency toCurrency, Calendar date) {
        HTTParser parser = HTTParser.getInstance();

        String answer = "";
        
        try {
            answer = parser.getHTTPAnswer(generateURL(fromCurrency, toCurrency, date));
        } catch (IOException ex) {
        }

        return new ExchangeRate(new Number(Double.valueOf(answer)), fromCurrency, toCurrency, date);
    }

    @Override
    public ExchangeRate load(Currency fromCurrency, Currency toCurrency) {
        return load(fromCurrency, toCurrency, Calendar.getInstance());

    }

    private URL generateURL(Currency fromCurrency, Currency toCurrency, Calendar date) {
        try {
            return new URL(URL + formatDate(date) + "/" + fromCurrency.getCode() + "/" + toCurrency.getCode());
        } catch (MalformedURLException ex) {
            Logger.getLogger(ChangeRateHTTPLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private String formatDate(Calendar date) {
        return date.get(Calendar.YEAR) + "-" + date.get(Calendar.MONTH) + "-" + date.get(Calendar.DAY_OF_MONTH);
    }

}
