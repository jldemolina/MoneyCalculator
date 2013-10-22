package moneycalculator;

import controller.ChangeRateController;

public class Main {

    public static void main(String[] args) {
        ChangeRateController controller = new ChangeRateController(args[0]);
        controller.run();
    }

}
