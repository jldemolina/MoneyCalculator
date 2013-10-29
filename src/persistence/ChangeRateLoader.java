package persistence;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import model.Number;
import model.Currency;
import model.ExchangeRate;

public class ChangeRateLoader {

    private static final String URL = "http://currencies.apps.grandtrunk.net/getrate/";

    public ChangeRateLoader() {
    }

    public ExchangeRate load(Currency fromCurrency, Currency toCurrency, Calendar date) {
        HTTParser parser = HTTParser.getInstance();

        String changeDate =  date.get(Calendar.YEAR) + "-" + date.get(Calendar.MONTH) + "-" + date.get(Calendar.DAY_OF_MONTH);

        URL url;
        String answer = "1";

        try {
            url = new URL(URL + changeDate + "/" + fromCurrency.getCode() + "/" + toCurrency.getCode());
            answer = parser.getHTTPAnswer(url);
            
        } catch (MalformedURLException ex) {
        } catch (IOException ex) {
        }
        double a = Double.valueOf(answer);
        return new ExchangeRate(new Number(Double.valueOf(answer)), fromCurrency, toCurrency, date);
    }

    public ExchangeRate load(Currency fromCurrency, Currency toCurrency) {
        return load(fromCurrency, toCurrency, Calendar.getInstance());

    }

}
