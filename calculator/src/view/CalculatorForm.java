package view;
import infixToPostfix.InfixToPostfix;
import calculate.Calculate;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorForm {
    private static CalculatorForm mForm;
    private JTextField textField;
    private JPanel buttonsPanel;
    private JButton bpButton;
    private JButton clearButton;
    private JButton leftParenthesisButton;
    private JButton rightParenthesisButton;
    private JButton sevenButton;
    private JButton eightButton;
    private JButton nineButton;
    private JButton divideButton;
    private JButton fourButton;
    private JButton fiveButton;
    private JButton sixButton;
    private JButton multiplicationButton;
    private JButton oneButton;
    private JButton twoButton;
    private JButton threeButton;
    private JButton subtractionButton;
    private JButton zeroButton;
    private JButton dotButton;
    private JButton equalButton;
    private JButton addButton;
    private JPanel mainPanel;
    private JButton exitButton;
    private JPanel exitPanel;
    private JPanel textPanel;

    private String string="";

    public CalculatorForm(){
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        bpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(string.length()>0)
                    string=string.substring(0,string.length()-1);
                textField.setText(string);
            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                string = "";
                textField.setText(string);
            }
        });
        leftParenthesisButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                string += "(";
                textField.setText(string);
            }
        });
        rightParenthesisButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                string+=")";
                textField.setText(string);
            }
        });
        sevenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                string+="7";
                textField.setText(string);
            }
        });
        eightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                string+="8";
                textField.setText(string);
            }
        });
        nineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                string+="9";
                textField.setText(string);
            }
        });
        divideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    string += "/";
                    textField.setText(string);
            }
        });
        fourButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                string+="4";
                textField.setText(string);
            }
        });
        fiveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                string+="5";
                textField.setText(string);
            }
        });
        sixButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                string+="6";
                textField.setText(string);
            }
        });
        multiplicationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    string += "*";
                    textField.setText(string);
            }
        });
        oneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                string+="1";
                textField.setText(string);
            }
        });
        twoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                string+="2";
                textField.setText(string);
            }
        });
        threeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                string+="3";
                textField.setText(string);
            }
        });
        subtractionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    string += "-";
                    textField.setText(string);
            }
        });
        zeroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                string+="0";
                textField.setText(string);
            }
        });
        dotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    string += ".";
                    textField.setText(string);
            }
        });
        equalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    string = String.valueOf(Calculate.calculate(InfixToPostfix.convertToPostfix(string)));
                    textField.setText(string);
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    string += "+";
                    textField.setText(string);
            }
        });
    }
    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("Calculator");
        mForm=new CalculatorForm();
        mainFrame.setContentPane(mForm.mainPanel);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
}
