package project1;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.*;
import java.text.NumberFormat;


public class SimpleDateGUIPanel extends JPanel {
    private SimpleDate simpledate;


    private JButton incrementButton;
    private JButton daysFromNowButton;
    private JButton daySinceButton;
    private JButton isLeapYearButton;
    private JButton toStringButton;
    private JButton ordinalDateButton;
    private JButton saveButton;
    private JButton loadButton;




    JTextField inputDateField, intField, otherDateField;

    JLabel label;

    public SimpleDateGUIPanel() {
        //simpledate = new SimpleDate();

        setLayout(new GridLayout(8, 2));

        inputDateField = new JTextField("1/1/2020", 1);
        add(inputDateField);
        add(new JLabel("Input Date:"));

        intField = new JTextField("1",1);
        add(intField);
        add(new JLabel("Input Integer:"));

        otherDateField = new JTextField("2/1/2020",1);
        add(otherDateField);
        add(new JLabel("Input Addt'l Date:"));



        incrementButton = new JButton("Increment 1 day");
        daysFromNowButton = new JButton("Days from current Date");
        daySinceButton = new JButton("Days since current Date");
        isLeapYearButton = new JButton("is it a Leap Year");
        toStringButton = new JButton("Show Date");
        ordinalDateButton = new JButton("Show Ordinal Date");
        saveButton = new JButton("Save Date");
        loadButton = new JButton("Load Date");


        add(incrementButton);
        add(daysFromNowButton);
        add(daySinceButton);
        add(isLeapYearButton);
        add(toStringButton);
        add(ordinalDateButton);
        add(saveButton);
        add(loadButton);

        label = new JLabel ("Date:");
        add(label);

        ButtonListener listen = new ButtonListener();
        incrementButton.addActionListener(listen);
        daysFromNowButton.addActionListener(listen);
        daySinceButton.addActionListener(listen);
        isLeapYearButton.addActionListener(listen);
        toStringButton.addActionListener(listen);
        ordinalDateButton.addActionListener(listen);
        saveButton.addActionListener(listen);
        loadButton.addActionListener(listen);
    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            if (arg0.getSource() == incrementButton){
                SimpleDate temp = new SimpleDate(inputDateField.getText());
                temp.increment();
                label.setText(temp.toString());
            }
            if (arg0.getSource() == daysFromNowButton){
                SimpleDate temp = new SimpleDate(inputDateField.getText());
                int i = Integer.parseInt(intField.getText());
                label.setText(temp.daysFromNow(i).toString());
            }
//            if (arg0.getSource() == daySinceButton);{
//                SimpleDate temp = new SimpleDate(inputDateField.getText());
//                SimpleDate temp2 = new SimpleDate(otherDateField.getText());
//                label.setText(temp.daysSince(temp2));
//            }
        }
    }


}
