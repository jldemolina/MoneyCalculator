package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import model.CurrencySet;
import persistence.ChangeRateDownloader;
import persistence.CurrencySetDownloader;
import view.ChangeRateView;

public class ChangeRateController {

    ChangeRateView view;

    public ChangeRateController(String currencyListFile) {
        view = new ChangeRateView();

        try {
            CurrencySetDownloader.getInstance().load(currencyListFile);
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
