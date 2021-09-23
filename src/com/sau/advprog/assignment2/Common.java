package com.sau.advprog.assignment2;

public enum Common {
    NAME("Please enter your name"),
    AGE("Please enter your age"),
    TITLE("Please enter your title"),
    SALARY("Please enter your salary"),
    PERCENTAGE("Enter the increment percentage"),
    EXPERIENCE("Enter your years of experience"),
    DEGREE("Enter your Degree"),
    BONUS("Enter your bonus");

    private final String Q;
    Common(String Q) {
        this.Q = Q;
    }
    public String getQ() {
        return this.Q;
    }
}
