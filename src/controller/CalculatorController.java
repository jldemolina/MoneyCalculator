package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Badge;
import model.Calculator;
import view.CalculatorView;

public class CalculatorController {

    Calculator model;
    CalculatorView view;

    public CalculatorController(Calculator model, CalculatorView view) {
        this.model = model;
        this.view = view;
        
        view.addConvertButtonListener(new ConvertButtonListener());

    }
        
    class ConvertButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String userInput = "";
            try {
            model.setBadge(new Badge(view.getFromInput(), view.getUserInput()));
            model.setDate(view.getDate());
            view.setTotal(model.convertTo(view.getToInput()));
            } catch (NumberFormatException nfex) {
                view.showErrorMessage("Bad input: '" + userInput + "'");
            } catch (IOException ex) {
                view.showErrorMessage("We have no information on the conversion of currencies.\n"
                        + "Probably did not exist at that time or not to be accounted");
            }
        }
    }
}
