package ui;

import java.util.Scanner;
import model.Number;

public class NumberDialog {

    private Number number;

    public void show() {
        System.out.println("Introduzca un número:");
        Scanner scanner = new Scanner(System.in);
        number = new Number(scanner.nextDouble());
    }

    public Number getNumber() {
        return number;
    }

}
