package com.sau.advprog.assignment2.SelectEmployeeType;

import javax.swing.*;
import java.awt.*;

public class SelectEmployeeType extends JFrame {
    private int WINDOW_HEIGHT = 400;
    private int WINDOW_WIDTH = 600;
    private String WINDOW_TITLE = "Select an Employee Type";

    public SelectEmployeeType() {
        this.setTitle(WINDOW_TITLE);
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // sending in a ref of the Frame so that actions on frame can be performed within the panel
        JPanel selectEmployeeTypePanel = new SelectEmployeeTypePanel(this);
        this.add(selectEmployeeTypePanel, BorderLayout.CENTER);
        this.setVisible(true);
    }
}
