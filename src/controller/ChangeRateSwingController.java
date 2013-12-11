package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import model.Currency;
import model.CurrencySet;
import model.ExchangeRate;
import model.Money;
import model.MoneyExchanger;
import view.persistence.ChangeRateLoader;
import view.persistence.CurrencySetLoader;
import view.ui.CurrencyPanel;
import view.ui.MoneyPanel;
import view.ui.MoneyViewer;
import view.ui.swing.SwingCalculatorFrame;

public class ChangeRateSwingController {

    private final CurrencySetLoader currencySetLoader;
    private final ChangeRateLoader changeRateLoader;
    private final SwingCalculatorFrame frame;
    private final MoneyPanel moneyPanel;
    private final MoneyViewer moneyViewer;
    private final CurrencyPanel currencyPanel;

    public ChangeRateSwingController(CurrencySetLoader currencySetLoader, ChangeRateLoader changeRateLoader, SwingCalculatorFrame frame, MoneyPanel moneyPanel, MoneyViewer moneyViewer, CurrencyPanel currencyPanel) {
        this.currencySetLoader = currencySetLoader;
        this.changeRateLoader = changeRateLoader;
        this.frame = frame;
        this.moneyPanel = moneyPanel;
        this.moneyViewer = moneyViewer;
        this.currencyPanel = currencyPanel;
    }

    public void execute() {
        currencySetLoader.load();
        createCalculatorFrame();
        frame.setVisible(true);
    }

    private void createCalculatorFrame() {
        fillCurrencyPanel();
        JPanel panel = new JPanel();
        panel.add(moneyPanel);
        panel.add(currencyPanel);
        panel.add(createCalculateButton());
        panel.add(createExitButton());
        frame.add(panel);
    }

    private JButton createCalculateButton() {
        JButton button = new JButton("Calculate");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                calculate();
            }
        });
        return button;
    }

    private JButton createExitButton() {
        JButton button = new JButton("Exit");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                exit();
            }
        });
        return button;
    }

    private void exit() {
        frame.dispose();
    }

    private void calculate() {
        ExchangeRate rate  = changeRateLoader.load(moneyPanel.getMoney().getCurrency(), currencyPanel.getCurrency());
        Money resultingMoney = MoneyExchanger.exchange(moneyPanel.getMoney().getAmount(), rate);
        moneyViewer.setMoney(resultingMoney);
        moneyViewer.show();    
    }

    private void fillCurrencyPanel() {
        Currency[] currencies = CurrencySet.getInstance().toArray(new Currency[0]);
        currencyPanel.fillComboBox(currencies);
        moneyPanel.getCurrencyPanel().fillComboBox(currencies);
    }

}
