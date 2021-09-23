package com.sau.advprog.assignment2.SelectEmployeeType;

import com.sau.advprog.assignment2.EmployeeForm.EmployeeForm;
import com.sau.advprog.assignment2.ManagerForm.ManagerForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectEmployeeTypePanel extends JPanel {
    JRadioButton employeeButton;
    JRadioButton managerButton;
    String selectedEmployeeType;
    JButton submitButton;
    SelectEmployeeType jFrameRef;

    SelectEmployeeTypePanel(SelectEmployeeType jFrameRef) {
        this.jFrameRef = jFrameRef;
        addHeading();
        addRadioButtons();
        addSubmitButton();
        // adding a layout
        this.setLayout(new GridLayout(4, 2));
    }

    private void addHeading() {
        // adding a heading for the Panel function / action
        JLabel heading = new JLabel("Please select an Employee type to proceed");
        this.add(heading);
    }

    private void addRadioButtons() {
        // instantiating with button text ; Using enums instead of constants for easy maintenance
        employeeButton = new JRadioButton(EmployeeType.EMPLOYEE.name());
        managerButton = new JRadioButton(EmployeeType.MANAGER.name());
        // adding action listeners for the buttons
        employeeButton.addActionListener(new EmployeeSelectButtonActionListener());
        managerButton.addActionListener(new EmployeeSelectButtonActionListener());
        // adding buttons to the button group so that only one radio button can be selected
        ButtonGroup selectEmployeeTypeBtnGroup = new ButtonGroup();
        selectEmployeeTypeBtnGroup.add(employeeButton);
        selectEmployeeTypeBtnGroup.add(managerButton);
        // adding buttons to the Panel for visibility
        this.add(employeeButton);
        this.add(managerButton);
    }

    private void addSubmitButton() {
        submitButton = new JButton("Proceed");
        submitButton.addActionListener(new SubmitButtonActionListener());
        this.add(submitButton);
    }


    private class EmployeeSelectButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if (actionEvent.getSource() == employeeButton) {
                selectedEmployeeType = EmployeeType.EMPLOYEE.name();
            } else if (actionEvent.getSource() == managerButton) {
                selectedEmployeeType = EmployeeType.MANAGER.name();
            }
        }
    }

    private class SubmitButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if (selectedEmployeeType == null) {
                JOptionPane.showMessageDialog(SelectEmployeeTypePanel.this,
                        "Please select an Employee type to proceed",
                        "Employee type not selected",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                System.out.println("Selected Employee type: " + selectedEmployeeType);
                if (selectedEmployeeType.equals(EmployeeType.EMPLOYEE.name())) {
                    EmployeeForm empForm = new EmployeeForm();
                } else if (selectedEmployeeType.equals(EmployeeType.MANAGER.name())) {
                    ManagerForm managerForm = new ManagerForm();
                }
                // calling parent JFrame's dispose method in order to close the current window
                SelectEmployeeTypePanel.this.jFrameRef.dispose();
            }
        }
    }

}
