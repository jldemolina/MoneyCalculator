package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import model.Currency;
import model.ChangeRate;
import view.ChangeRateView;

public class ChangeRateController {

    ChangeRate model;
    ChangeRateView view;

    public ChangeRateController(ChangeRate model, ChangeRateView view) {
        this.model = model;
        this.view = view;

        view.addConvertButtonListener(new ConvertButtonListener());
        view.addZeroButtonListener(new AuxiliarButtonListener("0"));
        view.addOneButtonListener(new AuxiliarButtonListener("1"));
        view.addTwoButtonListener(new AuxiliarButtonListener("2"));
        view.addThreeButtonListener(new AuxiliarButtonListener("3"));
        view.addFourButtonListener(new AuxiliarButtonListener("4"));
        view.addFiveButtonListener(new AuxiliarButtonListener("5"));
        view.addSixButtonListener(new AuxiliarButtonListener("6"));
        view.addSevenButtonListener(new AuxiliarButtonListener("7"));
        view.addEightButtonListener(new AuxiliarButtonListener("8"));
        view.addNineButtonListener(new AuxiliarButtonListener("9"));
        view.addPointButtonListener(new AuxiliarButtonListener("."));
        view.addAddButtonListener(new AuxiliarButtonListener("+"));
        view.addSubButtonListener(new AuxiliarButtonListener("-"));
        view.addcurrencyCodeComboListener(new CurrencyCodeComboListener());

    }

    private class ConvertButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String userInput = "";
            /*try {
             model.setBadge(new Currency(view.getFromInput(), view.getUserInput()));
             model.setDate(view.getDate());
             view.setTotal(model.convertTo(view.getToInput()));
             } catch (NumberFormatException nfex) {
             view.showErrorMessage("Bad input: '" + userInput + "'");
             } catch (IOException ex) {
             view.showErrorMessage("We have no information on the conversion of currencies.\n"
             + "Probably did not exist at that time or not to be accounted");
             }*/
        }

    }

    private class AuxiliarButtonListener implements ActionListener {

        private String buttonPressedValue;

        public AuxiliarButtonListener(String buttonPressedValue) {
            this.buttonPressedValue = buttonPressedValue;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            view.setUserInput(view.getUserInput() + buttonPressedValue);
        }

    }

    private class CurrencyCodeComboListener implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent itemEvent) {
            int state = itemEvent.getStateChange();
            System.out.println(itemEvent.getItem().toString());
        }

    }
}
