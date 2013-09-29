package view;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.freixas.jcalendar.JCalendar;

public class CalculatorView extends JFrame {

    private static final String INITIAL_VALUE = "1";
    private static final String APP_NAME = "Main Calculator";
    private static final String[] BADGES = new String[]{"EUR", "AED", "AFN", "ALL", "AMD", 
        "ANG", "AOA", "ARS", "ATS", "AUD", "AWG", "AZN", "BAM", "BBD", "BDT", "BEF", "BGN", "BHD",
        "BIF", "BMD", "BND", "BOB", "BRL", "BSD", "BTC", "BTN", "BWP", "BYR", "BZD", "CAD", "CDF", 
        "CHF", "CLF", "CLP", "CNH", "CNY", "COP", "CRC", "CUP", "CVE", "CYP", "CZK", "DEM", "DJF", 
        "DKK", "DOP", "DZD", "EEK", "EGP", "ESP", "ETB", "FIM", "FJD", "FKP", "FRF", "GBP", 
        "GEL", "GHS", "GIP", "GMD", "GNF", "GRD", "GTQ", "GYD", "HKD", "HNL", "HRK", "HTG", "HUF", 
        "IDR", "IEP", "ILS", "INR", "IQD", "IRR", "ISK", "ITL", "JEP", "JMD", "JOD", "JPY", "KES",
        "KGS", "KHR", "KMF", "KPW", "KRW", "KWD", "KYD", "KZT", "LAK", "LBP", "LKR", "LRD", "LSL", 
        "LTL", "LUF", "LVL", "LYD", "MAD", "MCF", "MDL", "MGA", "MKD", "MMK", "MNT", "MOP", "MRO", 
        "MTL", "MUR", "MVR", "MWK", "MXN", "MYR", "MZN", "NAD", "NGN", "NIO", "NLG", "NOK", "NPR", 
        "NZD", "OMR", "PAB", "PEN", "PGK", "PHP", "PKR", "PLN", "PTE", "PYG", "QAR", "RON", "RSD", 
        "RUB", "RWF", "SAR", "SBD", "SCR", "SDG", "SEK", "SGD", "SHP", "SIT", "SKK", "SLL", "SML",
        "SOS", "SRD", "STD", "SVC", "SYP", "SZL", "THB", "TJS", "TMT", "TND", "TOP", "TRY", "TTD", 
        "TWD", "TZS", "UAH", "UGX", "USD", "UYU", "UZS", "VAL", "VEB", "VEF", "VND", "VUV", "WST",
        "XAF", "XAG", "XAU", "XCD", "XCP", "XDR", "XOF", "XPD", "XPF", "XPT", "YER", "ZAR", "ZMK", 
        "ZMW", "ZWL"};

    private JTextField userInput;
    private JTextField convertionResult;
    private JButton converButton;
    private JComboBox jComBoxTo;
    private JComboBox jComBoxFrom;
    private JCalendar jCalendar;

    public CalculatorView() {

        userInput = new JTextField(5);
        convertionResult = new JTextField(20);
        converButton = new JButton("Convert");
        jComBoxTo = new JComboBox();
        jComBoxFrom = new JComboBox();
        jCalendar = new JCalendar();

        for (int i = 0; i < BADGES.length; i++) {
            jComBoxTo.addItem(BADGES[i]);
            jComBoxFrom.addItem(BADGES[i]);
        }

        initView();
    }

    private void initView() {
        JPanel content = new JPanel();
        content.setLayout(new FlowLayout());
        content.add(new JLabel("Input"));
        content.add(userInput);
        content.add(jComBoxFrom);
        content.add(jComBoxTo);
        content.add(new JLabel("Total"));
        content.add(convertionResult);
        content.add(converButton);

        JLabel label = new JLabel("Text");
        label.setText("You can choose a day if you want to know the value in other date.");
        content.add(label);
        content.add(jCalendar);

        this.setContentPane(content);
        this.pack();

        this.setTitle(APP_NAME);
        this.setSize(700, 350);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void reset() {
        convertionResult.setText(INITIAL_VALUE);
    }

    public void setTotal(double newTotal) {
        convertionResult.setText(String.valueOf(newTotal));
    }

    public void addConvertButtonListener(ActionListener mal) {
        converButton.addActionListener(mal);
    }

    public double getUserInput() {
        return Double.valueOf(userInput.getText());
    }

    public String getFromInput() {
        return this.jComBoxFrom.getSelectedItem().toString();
    }

    public String getToInput() {
        return this.jComBoxTo.getSelectedItem().toString();
    }

    public String getDate() {
        Calendar calendar = jCalendar.getCalendar();
        String date = calendar.get(Calendar.YEAR) + "-" + calendar.get(Calendar.MONTH) + "-" + calendar.get(Calendar.DATE);
        return date;
    }

    public void showErrorMessage(String errMessage) {
        JOptionPane.showMessageDialog(this, errMessage);
    }

}
