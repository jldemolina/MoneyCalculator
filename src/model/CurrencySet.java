package model;

import java.util.HashSet;

public class CurrencySet extends HashSet<Currency> {

    public static CurrencySet instance;

    private CurrencySet() {
        super();
    }

    public static CurrencySet getInstance() {
        if (instance == null)
            instance = new CurrencySet();
        return instance;
    }

    public Currency getCurrency(String code) {
        for (Currency currency : this)
            if (code.equals(currency.getCode()))
                return currency;
        return null;
    }

}
