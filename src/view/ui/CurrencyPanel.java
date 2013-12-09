package view.ui;

import javax.swing.JPanel;
import model.Currency;

public abstract class CurrencyPanel extends JPanel {
    
    public abstract Currency getCurrency();
    public abstract void fillComboBox(Currency[] currencies);
    
}
