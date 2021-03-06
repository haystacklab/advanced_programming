package com.sau.advprog.assignment1;

public class Employee implements Traits {
    private String myName;
    private String myTitle;
    protected double mySalary;
    private int myAge;

    public Employee(String name, String title, double salary, int age) {
        myName = name;
        myTitle = title;
        mySalary = salary;
        myAge = age;
    }

    public String getName() {
        return myName;
    }

    public String getTitle(){
        return myTitle;
    }

    public double getSalary(){
        return mySalary;
    }

    public int getAge(){
        return myAge;
    }

    public void raiseSalary(int percent) {
        mySalary = mySalary + percent * 0.01 * mySalary;
    }

    public void raiseSalary(int percent, int cost_of_living_adjustment) {
        mySalary = mySalary + percent * 0.01 * mySalary + cost_of_living_adjustment * 0.01 * mySalary;
    }
}
