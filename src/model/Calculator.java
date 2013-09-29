package model;

import java.io.IOException;
import view.CurrencyDownloader;

public class Calculator {

    private Badge badge;
    private String date;

    public Calculator() {
    }

    public void setBadge(Badge badge) {
        this.badge = badge;
    }
    
    public void setDate(String date) {
        this.date = date;
    }

    public double convertTo(String targetCurrency) throws IOException {
        double changeValue = new CurrencyDownloader(badge.getCurrency(), targetCurrency, date).getChangeValue();
        return changeValue * badge.getValue();
    }

    public Badge getBadge() {
        return badge;
    }
   
    

}
