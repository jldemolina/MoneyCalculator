/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author José Luis Molina. All rights reserved.
 */
public class CurrencyDownloader {

    private static final String URL = "http://currencies.apps.grandtrunk.net/getrate/";

    private String from;
    private String to;
    private String date;

    public CurrencyDownloader(String from, String to, String date) {
        this.from = from;
        this.to = to;
        this.date = date;
    }

    public double getChangeValue() throws IOException {
        HTTParser parser = new HTTParser(new URL(URL + date + "/" + from + "/" + to));

        String answer = parser.getHTTPAnswer();
        return Double.valueOf(answer);
    }
}
