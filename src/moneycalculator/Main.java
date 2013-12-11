package moneycalculator;

import controller.ChangeRateConsoleController;
import controller.ChangeRateSwingController;
import view.persistence.ChangeRateLoader;
import view.persistence.CurrencySetLoader;
import view.persistence.FileCurrencySetLoader;
import view.persistence.InternetChangeRateLoader;
import view.ui.console.ConsoleCurrencyDialog;
import view.ui.console.ConsoleMoneyDialog;
import view.ui.console.ConsoleMoneyViewer;
import view.ui.CurrencyDialog;
import view.ui.CurrencyPanel;
import view.ui.MoneyDialog;
import view.ui.MoneyPanel;
import view.ui.MoneyViewer;
import view.ui.swing.SwingCalculatorFrame;
import view.ui.swing.SwingCurrencyPanel;
import view.ui.swing.SwingMoneyPanel;

public class Main {

    public static void main(String[] args) {
        runAppUnderSwing(args[0]);
    }
    
    private static void runAppUnderConsole(String file) {
        CurrencySetLoader currencySetLoader = new FileCurrencySetLoader(file);
        ChangeRateLoader changeRateLoader = new InternetChangeRateLoader();
        MoneyDialog moneyDialog = new ConsoleMoneyDialog();
        MoneyViewer moneyViewer = new ConsoleMoneyViewer();
        CurrencyDialog currencyDialog = new ConsoleCurrencyDialog();
        
        ChangeRateConsoleController controller = new ChangeRateConsoleController(currencySetLoader, changeRateLoader,
                moneyDialog, moneyViewer, currencyDialog);
        controller.execute();  
    }
    
    private static void runAppUnderSwing(String file) {
        CurrencySetLoader currencySetLoader = new FileCurrencySetLoader(file);
        ChangeRateLoader changeRateLoader = new InternetChangeRateLoader();
        MoneyPanel moneyPanel = new SwingMoneyPanel();
        SwingCalculatorFrame frame = new SwingCalculatorFrame();
        MoneyViewer moneyViewer = new ConsoleMoneyViewer();
        CurrencyPanel CurrencyPanel = new SwingCurrencyPanel();
        
        ChangeRateSwingController controller = new ChangeRateSwingController(currencySetLoader, changeRateLoader, frame, moneyPanel, moneyViewer, CurrencyPanel);
        controller.execute();      
    }
}
