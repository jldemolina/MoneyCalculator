package controller;

import java.io.IOException;
import model.Currency;
import model.ExchangeRate;
import model.Money;
import model.MoneyExchanger;
import persistence.ChangeRateLoader;
import persistence.CurrencySetLoader;
import ui.CurrencyDialog;
import ui.NumberDialog;
import ui.MoneyViewer;
import model.Number;

public class ChangeRateController {

    public ChangeRateController(String currencyListFile) {
        try {
            CurrencySetLoader.getInstance().load(currencyListFile);
        } catch (IOException ex) {
        }

    }

    public void execute() {
        Number amount = getNumber();
        ExchangeRate rate  = new ChangeRateLoader().load(getCurrency(), getCurrency());
        Money money = MoneyExchanger.exchange(amount, rate);
        new MoneyViewer(money).show();
    }

    private model.Number getNumber() {
        NumberDialog numberDialog = new NumberDialog();
        numberDialog.show();
        return numberDialog.getNumber();
    }

    private Currency getCurrency() {
        CurrencyDialog dialog = new CurrencyDialog();
        dialog.show();
        return dialog.getCurrency();
    }
    
}
