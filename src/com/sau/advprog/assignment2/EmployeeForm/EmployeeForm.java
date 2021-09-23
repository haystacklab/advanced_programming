package com.sau.advprog.assignment2.EmployeeForm;

import com.sau.advprog.assignment2.SelectEmployeeType.SelectEmployeeTypePanel;

import javax.swing.*;
import java.awt.*;

public class EmployeeForm extends JFrame {
    private int WINDOW_HEIGHT = 500;
    private int WINDOW_WIDTH = 800;
    private String WINDOW_TITLE = "Employee details";

    public EmployeeForm() {
        this.setTitle(WINDOW_TITLE);
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel employeeFormPanel = new EmployeeFormPanel();
        this.add(employeeFormPanel, BorderLayout.CENTER);
        this.setVisible(true);
    }
}
