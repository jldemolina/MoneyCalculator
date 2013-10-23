package controller;

import java.io.IOException;
import persistence.CurrencySetLoader;
import ui.CurrencyDialog;

public class ChangeRateController {

    public ChangeRateController(String currencyListFile) {
        try {
            CurrencySetLoader.getInstance().load(currencyListFile);
        } catch (IOException ex) {
        }

    }

    public void execute() {
        CurrencyDialog currencyDialog = new CurrencyDialog();
        currencyDialog.show();
    }
}
