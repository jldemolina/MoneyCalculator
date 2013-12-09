package view.ui.swing;

import java.awt.Dimension;
import javax.swing.JFrame;
import view.ui.CalculatorFrame;


public final class SwingCalculatorFrame extends CalculatorFrame {

    private final String APP_NAME = "Money Calculator";

    public SwingCalculatorFrame() {
        configureDialog();
    }

    private void configureDialog() {
        setTitle(APP_NAME);
        setMinimumSize(new Dimension(1200, 70));
        setSize(new Dimension(1200, 65));
        setMaximumSize(new Dimension(1200, 70));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
