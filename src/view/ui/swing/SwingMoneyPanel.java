package view.ui.swing;

import javax.swing.JTextField;
import model.Money;
import model.Number;
import view.ui.CurrencyPanel;
import view.ui.MoneyPanel;

public class SwingMoneyPanel extends MoneyPanel {
    
     private final JTextField textField;
     private final SwingCurrencyPanel currencyPanel;

    public SwingMoneyPanel() {
        this.textField = new JTextField(10);
        this.currencyPanel = new SwingCurrencyPanel();
        this.add(textField);
        this.add(currencyPanel);
    }
    
    @Override
    public CurrencyPanel getCurrencyPanel() {
        return currencyPanel;
    }
    
    @Override
     public Money getMoney() {
         if (textField.getText().isEmpty()) textField.setText("0");
        return new Money(new Number(Double.valueOf(textField.getText())), currencyPanel.getCurrency());
    }
    
}
