package persistence;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import model.Currency;
import model.CurrencySet;

public class CurrencySetDownloader {

    private static CurrencySetDownloader instance;

    private CurrencySetDownloader() {

    }

    public static CurrencySetDownloader getInstance() {
        if (instance == null) {
            instance = new CurrencySetDownloader();
        }
        return instance;
    }

    public void load() throws IOException {
        String text;
        BufferedReader bufferedReader = new BufferedReader(new FileReader("currency_list.txt"));
        try {
            addItems(bufferedReader);
        } finally {
            bufferedReader.close();
        }
    }

    private void addItems(BufferedReader br) throws IOException {
        String line = br.readLine();

        String name = "";
        String code = "";
        String symbol = "";

        int i = 0;
        while (line != null) {
            if (i == 0) {
                name = line;
                i++;
            } else if (i == 1) {
                code = line;
                i++;
            } else {
                symbol = line;
                i = 0;
                CurrencySet.getInstance().add(new Currency(name, code, symbol));
            }
            line = br.readLine();
        }
    }

}
