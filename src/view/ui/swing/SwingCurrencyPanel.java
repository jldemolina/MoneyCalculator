package view.ui.swing;

import javax.swing.JComboBox;
import model.Currency;
import model.CurrencySet;
import view.ui.CurrencyPanel;

public class SwingCurrencyPanel extends CurrencyPanel {
    
    private final JComboBox comboBox;

    public SwingCurrencyPanel() {
        comboBox = new JComboBox();
        this.add(comboBox);
    }

    @Override
    public Currency getCurrency() {
        return CurrencySet.getInstance().search(comboBox.getSelectedItem().toString())[0];
    }
    
    @Override
    public void fillComboBox(Currency[] currencies) {
        for (Currency currency : currencies) {
            comboBox.addItem(currency.getCode());
        }
    }

}
