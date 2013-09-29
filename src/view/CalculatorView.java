package view;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import org.freixas.jcalendar.JCalendar;

public class CalculatorView extends JFrame {

    private static final String INITIAL_VALUE = "1";
    private static final String APP_NAME = "Main Calculator";
    private static final String[] BADGES = new String[]{"EUR", "USD"};

    private JTextField userInput = new JTextField(5);
    private JTextField convertionResult = new JTextField(20);
    private JButton converButton = new JButton("Convert");
    private JButton clearButton = new JButton("Clean");
    private JComboBox jComBoxTo = new JComboBox();
    private JComboBox jComBoxFrom = new JComboBox();
    private JCalendar jCalendar = new JCalendar();

    public CalculatorView() {

        userInput = new JTextField(5);
        convertionResult = new JTextField(20);
        converButton = new JButton("Convert");
        clearButton = new JButton("Clean");
        jComBoxTo = new JComboBox();
        jComBoxFrom = new JComboBox();
        jCalendar = new JCalendar();

        for (int i = 0; i < BADGES.length; i++) {
            jComBoxTo.addItem(BADGES[i]);
            jComBoxFrom.addItem(BADGES[i]);
        }

        setUpView();
    }

    private void setUpView() {
        JPanel content = new JPanel();
        content.setLayout(new FlowLayout());
        content.add(new JLabel("Input"));
        content.add(userInput);
        content.add(jComBoxFrom);
        content.add(jComBoxTo);
        content.add(new JLabel("Total"));
        content.add(convertionResult);
        content.add(converButton);
        content.add(clearButton);
        content.add(jCalendar);
        
        this.setContentPane(content);
        this.pack();

        this.setTitle(APP_NAME);
        this.setSize(800, 350);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void reset() {
        convertionResult.setText(INITIAL_VALUE);
    }

    public void setTotal(String newTotal) {
        convertionResult.setText(newTotal);
    }

    public void addConvertButtonListener(ActionListener mal) {
        converButton.addActionListener(mal);
    }

    public void addClearButtonListener(ActionListener cal) {
        clearButton.addActionListener(cal);
    }
    
    public String getUserInput() {
        return userInput.getText();
    }

    public void showErrorMessage(String errMessage) {
        JOptionPane.showMessageDialog(this, errMessage);
    }

}
