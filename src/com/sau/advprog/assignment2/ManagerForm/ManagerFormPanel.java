package com.sau.advprog.assignment2.ManagerForm;

import com.sau.advprog.assignment1.Manager;
import com.sau.advprog.assignment2.Common;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagerFormPanel extends JPanel {
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

    private int experience;
    JTextField experienceField;

    private String degree;
    JTextField degreeField;

    private double bonus;
    JTextField bonusField;

    ManagerFormPanel() {
        addForm();
        // adding a layout
        this.setLayout(new GridLayout(9, 3));
    }

    private void addForm() {
        // name, title, salary, age, increment percentage
        nameField();
        titleField();
        salaryField();
        ageField();
        percentageIncrement();
        experienceField();
        degreeField();
        bonusField();
        calculateIncrementedSalaryButton();
    }

    private void calculateIncrementedSalaryButton() {
        JButton calculateIncrementButton = new JButton("Calculate incremented salary");
        calculateIncrementButton.addActionListener(new ManagerFormPanel.CalculateIncrementActionListener());
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
//        nameField.setText("John Doe");
        this.add(nameLabel);
        this.add(nameField);
    }

    private void titleField() {
        JLabel titleLabel = new JLabel(Common.TITLE.getQ());
        titleField = new JTextField(10);
//        titleField.setText("Department Head");
        this.add(titleLabel);
        this.add(titleField);
    }

    private void salaryField() {
        JLabel salaryLabel = new JLabel(Common.SALARY.getQ());
        salaryField = new JTextField(10);
//        salaryField.setText("100000");
        this.add(salaryLabel);
        this.add(salaryField);
    }

    private void ageField() {
        JLabel ageLabel = new JLabel(Common.AGE.getQ());
        ageField = new JTextField(10);
//        ageField.setText("55");
        this.add(ageLabel);
        this.add(ageField);
    }

    private void experienceField() {
        JLabel experienceLabel = new JLabel(Common.EXPERIENCE.getQ());
        experienceField = new JTextField(10);
//        experienceField.setText("30");
        this.add(experienceLabel);
        this.add(experienceField);
    }

    private void degreeField() {
        JLabel degreeLabel = new JLabel(Common.DEGREE.getQ());
        degreeField = new JTextField(10);
//        degreeField.setText("PhD");
        this.add(degreeLabel);
        this.add(degreeField);
    }

    private void bonusField() {
        JLabel bonusLabel = new JLabel(Common.BONUS.getQ());
        bonusField = new JTextField(10);
//        bonusField.setText("5000");
        this.add(bonusLabel);
        this.add(bonusField);
    }

    private EvaluateData IsDataValid() {
        // check for two conditions: empty and invalid
        /* Two levels of validation: 1. Have all the fields been entered? 2. Are the fields entered correct?  */
        if (nameField.getText().equals("") || titleField.getText().equals("") || ageField.getText().equals("") || salaryField.getText().equals("") || percentageField.getText().equals("")) {
            return new ManagerFormPanel.EvaluateData("Please enter all the details to continue");
        }
        /* Checking the data validity and assigning a custom message as per which validation has failed  */

        /* Evaluating criteria for age: number and age greater than 100 */
        if (!isInt(ageField.getText())) return new ManagerFormPanel.EvaluateData("Age is a number only");
        if (Integer.parseInt(ageField.getText()) > 100) return new ManagerFormPanel.EvaluateData("Are you sure you are that old?");
        /* Evaluating salary: has to be a number only */
        if (!isDouble(salaryField.getText())) return new ManagerFormPanel.EvaluateData("Salary is a number only");
        /* Evaluating percentage: number and cannot be greater than 100 */
        if (!isInt(percentageField.getText())) return new ManagerFormPanel.EvaluateData("Percentage is a number only");
        if (Integer.parseInt(percentageField.getText()) > 100) return new ManagerFormPanel.EvaluateData("Percentage cannot be greater than 100");
        /* Evaluating percentage field: number and cannot be greater than 50 */
        if (!isInt(experienceField.getText())) return new ManagerFormPanel.EvaluateData("Experience is a number only");
        if (Integer.parseInt(experienceField.getText()) > 50) return new ManagerFormPanel.EvaluateData("Percentage cannot be greater than 50");
        /* Evaluating degree: cannot be a number */
        if (isInt(degreeField.getText())) return new ManagerFormPanel.EvaluateData("Degree cannot be a number");
        /* Evaluating bonus: has to be a number (double) */
        if (!isDouble(bonusField.getText())) return new ManagerFormPanel.EvaluateData("Bonus is a number only");

        return assignValuesAndReturn();
    }

    private EvaluateData assignValuesAndReturn() {
        // assigning all values as they have been validated
        name = nameField.getText();
        title = titleField.getText();
        age = Integer.parseInt(ageField.getText());
        salary = Double.parseDouble(salaryField.getText());
        percentage = Integer.parseInt(percentageField.getText());
        experience = Integer.parseInt(experienceField.getText());
        degree = degreeField.getText();
        bonus = Double.parseDouble(bonusField.getText());

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
        // If only string is passed, then evaluate condition has failed and need to add message only
        EvaluateData(String message) {
            this.message = message;
        }
        // overloading constructor to pass in second parameter if required
        // If evaluate condition has passed, then need to passed iValid true only, no message required
        EvaluateData(Boolean isValid) {
            this.isValid = isValid;
        }
    }

    private class CalculateIncrementActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            ManagerFormPanel.EvaluateData resp = ManagerFormPanel.this.IsDataValid();
            /* Checking for data validity */
            if (!resp.isValid) {
                /* Printing a custom message sent by the method */
                JOptionPane.showMessageDialog(ManagerFormPanel.this,
                        resp.message,
                        "Error: invalid input",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                Manager m = new Manager(ManagerFormPanel.this.name, ManagerFormPanel.this.title, ManagerFormPanel.this.salary,
                        ManagerFormPanel.this.age, ManagerFormPanel.this.experience, ManagerFormPanel.this.degree, ManagerFormPanel.this.bonus);
                m.raiseSalary(ManagerFormPanel.this.percentage);
                String confirmText = "Dear " + m.getName() + ", you are onboarded as "
                        + m.getTitle() + ", as one of our managers with " + m.getExperience() + " years of experience. "
                        + "\n You have a " + m.getDegree() + " degree and are assigned a signing bonus of " + m.getBonus()
                        + ".\n As per your increment of " + ManagerFormPanel.this.percentage + "%, your new salary has been raised to: " + m.getSalary();
                JOptionPane.showMessageDialog(ManagerFormPanel.this,
                        confirmText,
                        "Thank you for registering",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}
