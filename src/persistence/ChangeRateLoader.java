package persistence;

import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import model.Currency;

public class ChangeRateLoader {

    private static final String URL = "http://currencies.apps.grandtrunk.net/getrate/";

    private final Currency fromCurrency;
    private final Currency toCurrency;
    private final Calendar date;

    public ChangeRateLoader(Currency fromCurrency, Currency toCurrency, Calendar date) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.date = date;
    }

    public double getChangeValue() throws IOException {
        HTTParser parser = HTTParser.getInstance();

        int day = date.get(Calendar.DAY_OF_MONTH);
        int month = date.get(Calendar.MONTH);
        int year = date.get(Calendar.YEAR);
        String changeDate = year + "-" + month + "-" + day;

        URL url = new URL(URL + changeDate + "/" + fromCurrency.getCode() + "/" + toCurrency.getCode());
        String answer = parser.getHTTPAnswer(url);
        return Double.valueOf(answer);
    }

}
