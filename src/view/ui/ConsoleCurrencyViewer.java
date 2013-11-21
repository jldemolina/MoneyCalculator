package view.ui;

import model.Currency;

public class ConsoleCurrencyViewer implements CurrencyViewer {
    
    private Currency currency;

    public ConsoleCurrencyViewer(Currency currency) {
        this.currency = currency;
    }

    @Override
    public void show() {
        System.out.println(currency);
    }

    @Override
    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

}
