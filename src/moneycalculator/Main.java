package moneycalculator;

import controller.ChangeRateController;
import view.persistence.ChangeRateLoader;
import view.persistence.CurrencySetLoader;
import view.persistence.FileCurrencySetLoader;
import view.persistence.InternetChangeRateLoader;
import view.ui.ConsoleCurrencyDialog;
import view.ui.ConsoleMoneyDialog;
import view.ui.ConsoleMoneyViewer;
import view.ui.CurrencyDialog;
import view.ui.MoneyDialog;
import view.ui.MoneyViewer;

public class Main {

    public static void main(String[] args) {
        CurrencySetLoader currencySetLoader = new FileCurrencySetLoader(args[0]);
        ChangeRateLoader changeRateLoader = new InternetChangeRateLoader();
        MoneyDialog moneyDialog = new ConsoleMoneyDialog();
        MoneyViewer moneyViewer = new ConsoleMoneyViewer();
        CurrencyDialog currencyDialog = new ConsoleCurrencyDialog();
        
        ChangeRateController controller = new ChangeRateController(currencySetLoader, changeRateLoader, moneyDialog, moneyViewer, currencyDialog);
        controller.execute();    
    }
}
