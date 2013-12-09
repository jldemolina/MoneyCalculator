package view.ui;

import javax.swing.JPanel;
import model.Money;

public abstract class MoneyPanel extends JPanel {
    
    public abstract Money getMoney();
    public abstract CurrencyPanel getCurrencyPanel();
    
}

