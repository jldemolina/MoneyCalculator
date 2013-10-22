package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import model.Currency;
import model.CurrencySet;
import persistence.CurrencySetLoader;
import view.ChangeRateView;
import model.Number;

public class ChangeRateController {

    ChangeRateView view;

    public ChangeRateController(String currencyListFile) {
        view = new ChangeRateView();

        try {
            CurrencySetLoader.getInstance().load(currencyListFile);
        } catch (IOException ex) {
        }
        
        view.setCurrencyCodes(CurrencySet.getInstance());
        view.addConvertButtonListener(new ConvertButtonListener());
        view.addAddButtonListener(new AddButtonListener());
        view.addSubButtonListener(new SubButtonListener());
        
    }

    public void run() {
        view.setVisible(true);
    }

    private class ConvertButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Number amount = new Number(view.getAmount());
            
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
