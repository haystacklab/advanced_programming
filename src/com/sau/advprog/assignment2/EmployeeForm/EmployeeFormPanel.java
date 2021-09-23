package com.sau.advprog.assignment2.EmployeeForm;

import com.sau.advprog.assignment1.Employee;
import com.sau.advprog.assignment2.Common;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeFormPanel extends JPanel {
    private String name;
    private JTextField nameField;

    private String title;
    private JTextField titleField;

    private double salary;
    private JTextField salaryField;

    private int age;
    private JTextField ageField;

    private int percentage;
    JTextField percentageField;

    EmployeeFormPanel() {
        addForm();
        // adding a layout
        this.setLayout(new GridLayout(6, 3));
    }

    private void addForm() {
        // name, title, salary, age
        nameField();
        titleField();
        salaryField();
        ageField();
        percentageIncrement();
        calculateIncrementedSalaryButton();
    }

    private void calculateIncrementedSalaryButton() {
        JButton calculateIncrementButton = new JButton("Calculate incremented salary");
        calculateIncrementButton.addActionListener(new CalculateIncrementActionListener());
        this.add(calculateIncrementButton);
    }

    private void percentageIncrement() {
        JLabel percentageLabel = new JLabel(Common.PERCENTAGE.getQ());
        percentageField = new JTextField(3);
//        percentageField.setText("10");
        this.add(percentageLabel);
        this.add(percentageField);
    }

    private void nameField() {
        JLabel nameLabel = new JLabel(Common.NAME.getQ());
        nameField = new JTextField(10);
//        nameField.setText("Jane Doe");
        this.add(nameLabel);
        this.add(nameField);
    }

    private void titleField() {
        JLabel titleLabel = new JLabel(Common.TITLE.getQ());
        titleField = new JTextField(10);
//        titleField.setText("Resource Analyst");
        this.add(titleLabel);
        this.add(titleField);
    }

    private void salaryField() {
        JLabel salaryLabel = new JLabel(Common.SALARY.getQ());
        salaryField = new JTextField(10);
//        salaryField.setText("75000");
        this.add(salaryLabel);
        this.add(salaryField);
    }

    private void ageField() {
        JLabel ageLabel = new JLabel(Common.AGE.getQ());
        ageField = new JTextField(10);
//        ageField.setText("40");
        this.add(ageLabel);
        this.add(ageField);
    }

    private EvaluateData IsDataValid() {
        // check for two conditions: empty and invalid
        if (nameField.getText().equals("") || titleField.getText().equals("") || ageField.getText().equals("") || salaryField.getText().equals("") || percentageField.getText().equals("")) {
            return new EvaluateData("Please enter all the details to continue");
        }
        if (!isInt(ageField.getText())) return new EvaluateData("Age is a number only");
        if (Integer.parseInt(ageField.getText()) > 100) return new EvaluateData("Are you sure you are that old?");
        if (!isDouble(salaryField.getText())) return new EvaluateData("Salary is a number only");
        if (!isInt(percentageField.getText())) return new EvaluateData("Percentage is a number only");
        if (Integer.parseInt(percentageField.getText()) > 100) return new EvaluateData("Percentage cannot be greater than 100");

        // assigning all values as they have been validated
        name = nameField.getText();
        title = titleField.getText();
        age = Integer.parseInt(ageField.getText());
        salary = Double.parseDouble(salaryField.getText());
        percentage = Integer.parseInt(percentageField.getText());

        return new EvaluateData(true);
    }

    private boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    private boolean isInt(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    private class EvaluateData {
        Boolean isValid = false;
        String message;
        EvaluateData(String message) {
            this.message = message;
        }
        // overloading constructor to pass in second parameter if required
        EvaluateData(Boolean isValid) {
            this.isValid = isValid;
        }
    }

    private class CalculateIncrementActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            EvaluateData resp = EmployeeFormPanel.this.IsDataValid();
            if (!resp.isValid) {
                JOptionPane.showMessageDialog(EmployeeFormPanel.this,
                        resp.message,
                        "Error: invalid input",
                        JOptionPane.ERROR_MESSAGE);
            }
            Employee e1 = new Employee(EmployeeFormPanel.this.name, EmployeeFormPanel.this.title, EmployeeFormPanel.this.salary,
                    EmployeeFormPanel.this.age);
            e1.raiseSalary(EmployeeFormPanel.this.percentage);
            String confirmText = "Dear " + e1.getName() + ", you are onboarded as " + e1.getTitle()
                    + ".\n As per your increment of " + EmployeeFormPanel.this.percentage + "%, your new salary has been raised to: " + e1.getSalary();
            JOptionPane.showMessageDialog(EmployeeFormPanel.this,
                    confirmText,
                    "Thank you for registering",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
