package com.sau.advprog.assignment2.ManagerForm;

import com.sau.advprog.assignment2.EmployeeForm.EmployeeFormPanel;

import javax.swing.*;
import java.awt.*;

public class ManagerForm extends JFrame {
    private int WINDOW_HEIGHT = 500;
    private int WINDOW_WIDTH = 800;
    private String WINDOW_TITLE = "Manager details";

    public ManagerForm() {
        this.setTitle(WINDOW_TITLE);
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel managerFormPanel = new ManagerFormPanel();
        this.add(managerFormPanel, BorderLayout.CENTER);
        this.setVisible(true);
    }
}
