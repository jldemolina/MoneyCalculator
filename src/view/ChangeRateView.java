package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.freixas.jcalendar.JCalendar;

public class ChangeRateView extends JFrame {

    private static final String INITIAL_VALUE = "1";
    private static final String APP_NAME = "Money Calculator";
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

    private final JTextField userInput;
    private final JTextField convertionResult;
    private final JButton converButton;
    private final JComboBox jComBoxTo;
    private final JComboBox jComBoxFrom;
    private final JCalendar jCalendar;
    private final JButton zeroButton;
    private final JButton oneButton;
    private final JButton twoButton;
    private final JButton threeButton;
    private final JButton fourButton;
    private final JButton fiveButton;
    private final JButton sixButton;
    private final JButton sevenButton;
    private final JButton eightButton;
    private final JButton nineButton;
    private final JButton pointButton;
    private final JButton addButton;
    private final JButton subButton;

    public ChangeRateView() {

        userInput = new JTextField(45);
        convertionResult = new JTextField(20);
        converButton = new JButton("Convert");
        jComBoxTo = new JComboBox();
        jComBoxFrom = new JComboBox();
        jCalendar = new JCalendar();

        zeroButton = new JButton("0");
        oneButton = new JButton("1");
        twoButton = new JButton("2");
        threeButton = new JButton("3");
        fourButton = new JButton("4");
        fiveButton = new JButton("5");
        sixButton = new JButton("6");
        sevenButton = new JButton("7");
        eightButton = new JButton("8");
        nineButton = new JButton("9");
        pointButton = new JButton(".");
        addButton = new JButton("+");
        subButton = new JButton("-");

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
        content.add(new JLabel("to"));
        content.add(jComBoxTo);
        content.add(new JLabel("="));
        content.add(convertionResult);
        content.add(converButton);

        content.add(zeroButton);
        content.add(oneButton);
        content.add(twoButton);
        content.add(threeButton);
        content.add(fourButton);
        content.add(fiveButton);
        content.add(sixButton);
        content.add(sevenButton);
        content.add(eightButton);
        content.add(nineButton);
        content.add(pointButton);
        content.add(jComBoxFrom);
        content.add(addButton);
        content.add(subButton);

        content.add(jCalendar);

        this.setContentPane(content);

        this.setTitle(APP_NAME);
        this.setMinimumSize(new Dimension(1150, 95));
        this.setSize(new Dimension(1150, 350));
        this.setMaximumSize(new Dimension(1150, 350));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public String getUserInput() {
        return String.valueOf(userInput.getText());
    }

    public String getToInput() {
        return this.jComBoxTo.getSelectedItem().toString();
    }
    
    public String getCurrencyComboCode() {
       return this.jComBoxFrom.getSelectedItem().toString();
    }

    public String getDate() {
        Calendar calendar = jCalendar.getCalendar();
        String date = calendar.get(Calendar.YEAR) + "-" + calendar.get(Calendar.MONTH) + "-" + calendar.get(Calendar.DATE);
        return date;
    }

    public void setTotal(double newTotal) {
        convertionResult.setText(String.valueOf(newTotal));
    }
    
    public void setUserInput(String newInput) {
        userInput.setText(String.valueOf(newInput));
    }
    
    public void addConvertButtonListener(ActionListener mal) {
        converButton.addActionListener(mal);
    }

    public void addZeroButtonListener(ActionListener mal) {
        zeroButton.addActionListener(mal);
    }

    public void addOneButtonListener(ActionListener mal) {
        oneButton.addActionListener(mal);
    }

    public void addTwoButtonListener(ActionListener mal) {
        twoButton.addActionListener(mal);
    }

    public void addThreeButtonListener(ActionListener mal) {
        threeButton.addActionListener(mal);
    }

    public void addFourButtonListener(ActionListener mal) {
        fourButton.addActionListener(mal);
    }

    public void addFiveButtonListener(ActionListener mal) {
        fiveButton.addActionListener(mal);
    }

    public void addSixButtonListener(ActionListener mal) {
        sixButton.addActionListener(mal);
    }

    public void addSevenButtonListener(ActionListener mal) {
        sevenButton.addActionListener(mal);
    }

    public void addEightButtonListener(ActionListener mal) {
        eightButton.addActionListener(mal);
    }

    public void addNineButtonListener(ActionListener mal) {
        nineButton.addActionListener(mal);
    }

    public void addPointButtonListener(ActionListener mal) {
        pointButton.addActionListener(mal);
    }

    public void addAddButtonListener(ActionListener mal) {
        addButton.addActionListener(mal);
    }

    public void addSubButtonListener(ActionListener mal) {
        subButton.addActionListener(mal);
    }

    public void addcurrencyCodeComboListener(ItemListener mal) {
        subButton.addItemListener(mal);
    }

    public void showErrorMessage(String errMessage) {
        JOptionPane.showMessageDialog(this, errMessage);
    }

}
