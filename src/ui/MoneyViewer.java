package ui;

import model.Money;

public class MoneyViewer {
    private final Money money;

    public MoneyViewer(Money money) {
        this.money = money;
    }
    
    public void show() {
        System.out.println(money);
    }
    
}
