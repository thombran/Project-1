package project1;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.*;
import java.io.*;
import java.text.NumberFormat;


public class SimpleDateGUIPanel extends JPanel {
    private SimpleDate simpledate;

    private final JButton incrementButton, daysFromNowButton, daySinceButton, isLeapYearButton,
            toStringButton, ordinalDateButton, changeButton, saveButton, loadButton;

    JTextField inputDateField, intField, otherDateField;

    JLabel label;

    JFileChooser chooser;

    public SimpleDateGUIPanel() {
        //simpledate = new SimpleDate();

        setLayout(new GridLayout(8, 2));

        inputDateField = new JTextField("1/1/2020", 1);
        add(inputDateField);
        add(new JLabel("Input Date:"));

        intField = new JTextField("1", 1);
        add(intField);
        add(new JLabel("Input Integer:"));

        otherDateField = new JTextField("2/1/2020", 1);
        add(otherDateField);
        add(new JLabel("Input Addt'l Date:"));

        chooser = new JFileChooser();
        chooser.setDialogTitle("File selector");

        incrementButton = new JButton("Increment 1 day");
        daysFromNowButton = new JButton("Days from current Date");
        daySinceButton = new JButton("Days since current Date");
        isLeapYearButton = new JButton("is it a Leap Year");
        toStringButton = new JButton("Show Date");
        ordinalDateButton = new JButton("Show Ordinal Date");
        changeButton = new JButton("Change Date");
        saveButton = new JButton("Save");
        loadButton = new JButton("Load");

        add(incrementButton);
        add(daysFromNowButton);
        add(daySinceButton);
        add(isLeapYearButton);
        add(toStringButton);
        add(ordinalDateButton);
        add(saveButton);
        add(loadButton);
        add(changeButton);

        label = new JLabel("Date:");
        add(label);

        ButtonListener listen = new ButtonListener();

        incrementButton.addActionListener(listen);
        daysFromNowButton.addActionListener(listen);
        daySinceButton.addActionListener(listen);
        isLeapYearButton.addActionListener(listen);
        toStringButton.addActionListener(listen);
        ordinalDateButton.addActionListener(listen);
        changeButton.addActionListener(listen);
        saveButton.addActionListener(listen);
        loadButton.addActionListener(listen);

    }

    private class ButtonListener implements ActionListener {
        SimpleDate inc = new SimpleDate(inputDateField.getText());

        public void actionPerformed(ActionEvent arg0) {
            if (arg0.getSource() == changeButton) {
                inc = new SimpleDate(inputDateField.getText());
                label.setText(inc.toString());
            }
            if (arg0.getSource() == incrementButton) {
                inc.increment();
                label.setText(inc.toString());
            }
            if (arg0.getSource() == daysFromNowButton) {
                SimpleDate temp = new SimpleDate(inputDateField.getText());
                int i = Integer.parseInt(intField.getText());
                label.setText(temp.daysFromNow(i).toString());
            }
            if (arg0.getSource() == daySinceButton) {
                SimpleDate temp = new SimpleDate(inputDateField.getText());
                SimpleDate temp2 = new SimpleDate(otherDateField.getText());
                String s = Integer.toString(temp.daysSince(temp2));
                label.setText(s);
            }
            if (arg0.getSource() == isLeapYearButton) {
                SimpleDate temp = new SimpleDate(inputDateField.getText());
                label.setText(String.valueOf(temp.isLeapYear()));
            }
            if (arg0.getSource() == toStringButton) {
                SimpleDate temp = new SimpleDate(inputDateField.getText());
                label.setText(temp.toString());
            }
            if (arg0.getSource() == ordinalDateButton) {
                SimpleDate temp = new SimpleDate(inputDateField.getText());
                label.setText(String.valueOf(temp.ordinalDate()));
            }
            if (arg0.getSource() == saveButton) {
                SimpleDate temp = new SimpleDate(inputDateField.getText());
                chooser.showSaveDialog(getParent());
                File f = chooser.getSelectedFile();
                StringBuilder sb = new StringBuilder();
                temp.save(chooser.getName(f));
                label.setText(temp.toString() + " saved!");
            }
            if (arg0.getSource() == loadButton) {
                SimpleDate temp = new SimpleDate(inputDateField.getText());
                chooser.showOpenDialog(getParent());
                File f = chooser.getSelectedFile();
                StringBuilder sb = new StringBuilder();
                temp.load(chooser.getName(f));
                label.setText(temp.toString() + " loaded!");
            }
        }

    }
}
