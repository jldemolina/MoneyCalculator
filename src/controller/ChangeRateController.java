package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Currency;
import model.CurrencySet;
import model.ExchangeRate;
import model.Money;
import model.MoneyExchanger;
import view.ui.ChangeRateView;
import model.Number;
import view.persistence.ChangeRateHTTPLoader;
import view.persistence.CurrencySetFileLoader;
import view.persistence.CurrencySetLoader;

public class ChangeRateController {

    ChangeRateView view;

    public ChangeRateController(String currencyListFile) {
        view = new ChangeRateView();

        CurrencySetLoader loader = new CurrencySetFileLoader(currencyListFile);
        loader.load();

        view.setCurrencyCodes(CurrencySet.getInstance());
        view.addConvertButtonListener(new ConvertButtonListener());
        view.addAddButtonListener(new AddButtonListener());
        view.addSubButtonListener(new SubButtonListener());

    }
    
    public void execute() {
        view.setVisible(true);
    }


    private class ConvertButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(view.getToCurrency());
            System.out.println(view.getFromCurrency());
            Number amount = new Number(view.getAmount());
            Currency fromCurrency = CurrencySet.getInstance().search(view.getFromCurrency())[0];
            Currency toCurrency = CurrencySet.getInstance().search(view.getToCurrency())[0];
            ExchangeRate rate  = new ChangeRateHTTPLoader().load(fromCurrency, toCurrency);
            Money money = MoneyExchanger.exchange(amount, rate);
            view.setResult(money.getAmount().toString());
        }

    }

    private class AddButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }

    }

    private class SubButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }

    }

}
