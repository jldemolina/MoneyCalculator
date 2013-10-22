package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Currency;
import model.CurrencySet;

public final class ChangeRateView extends JFrame {

    private final String APP_NAME = "Money Calculator";

    private final JTextField amount;
    private final JTextField dateConvertionInput;
    private final JTextField resultOutput;

    private final JComboBox toCurrency;
    private final JComboBox fromCurrency;

    private final JButton addButton;
    private final JButton subButton;
    private final JButton convertButton;

    public ChangeRateView() {

        amount = new JTextField(20);
        dateConvertionInput = new JTextField(10);
        resultOutput = new JTextField(10);
        toCurrency = new JComboBox();
        fromCurrency = new JComboBox();

        convertButton = new JButton("convert!");
        addButton = new JButton("+");
        subButton = new JButton("-");

        initializeContent();
        configureDialog();

    }

    public void initializeContent() {
        JPanel content = new JPanel();
        content.setLayout(new FlowLayout());
        content.add(new JLabel(" From"));
        content.add(amount);
        content.add(fromCurrency);
        content.add(new JLabel(" to "));
        content.add(toCurrency);
        content.add(new JLabel(" at data "));
        content.add(dateConvertionInput);
        content.add(convertButton);
        content.add(addButton);
        content.add(subButton);
        content.add(new JLabel(" = "));
        content.add(resultOutput);
        setContentPane(content);
    }

    private void configureDialog() {
        setTitle(APP_NAME);
        setMinimumSize(new Dimension(1200, 70));
        setSize(new Dimension(1200, 65));
        setMaximumSize(new Dimension(1200, 70));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public Double getAmount() {
        return Double.valueOf(amount.getText());
    }

    public String getToCurrency() {
        return toCurrency.getSelectedItem().toString();
    }

    public String getFromCurrency() {
        return fromCurrency.getSelectedItem().toString();
    }

    public String getDate() {
        return String.valueOf(dateConvertionInput.getText());
    }

    public void setResult(String newTotal) {
        amount.setText(String.valueOf(newTotal));
    }

    public void setAmount(String newInput) {
        amount.setText(String.valueOf(newInput));
    }

    public void addAddButtonListener(ActionListener mal) {
        addButton.addActionListener(mal);
    }

    public void addSubButtonListener(ActionListener mal) {
        subButton.addActionListener(mal);
    }

    public void addConvertButtonListener(ActionListener mal) {
        convertButton.addActionListener(mal);
    }

    public void setCurrencyCodes(CurrencySet currencies) {
        for (Currency currency : currencies) {
            toCurrency.addItem(currency.getCode());
            fromCurrency.addItem(currency.getCode());
        }
    }

}
