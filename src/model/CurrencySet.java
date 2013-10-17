package model;

import java.util.HashSet;

public class CurrencySet extends HashSet<Currency> {

    public static CurrencySet instance;

    private CurrencySet() {
    }

    public static CurrencySet getInstance() {
        if (instance == null)
            instance = new CurrencySet();
        return instance;
    }
    
    
}
