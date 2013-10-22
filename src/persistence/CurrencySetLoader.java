package persistence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import model.Currency;
import model.CurrencySet;

public class CurrencySetLoader {

    private static CurrencySetLoader instance;

    private CurrencySetLoader() {

    }

    public static CurrencySetLoader getInstance() {
        if (instance == null)
            instance = new CurrencySetLoader();
        return instance;
    }

    public void load(String file) throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(file)));
            while (true) {
                String line = reader.readLine();
                if (line == null) 
                    break;
                String[] currency = line.split(",");
                CurrencySet.getInstance().add(new Currency(currency[2], currency[0], currency[1]));
            }
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
    }

}