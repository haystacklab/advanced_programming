package com.sau.advprog.project.model;

import java.util.Arrays;
import java.util.List;

public class Student {

    private String name;

//    giving a default value
    private String final_letter_grade = "F";

    private Double final_numerical_grade;

    private Integer hw1Marks = 0;
    private Integer hw2Marks = 0;
    private Integer hw3Marks = 0;
    private Integer midtermMarks = 0;
    private Integer projectMarks = 0;
    private Integer finalMarks = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFinal_letter_grade() {
        return final_letter_grade;
    }

    public void setFinal_letter_grade(String final_letter_grade) {
        this.final_letter_grade = final_letter_grade;
    }

    public Integer getHw1Marks() {
        return hw1Marks;
    }

    public void setHw1Marks(Integer hw1Marks) {
        this.hw1Marks = hw1Marks;
    }

    public Integer getHw2Marks() {
        return hw2Marks;
    }

    public void setHw2Marks(Integer hw2Marks) {
        this.hw2Marks = hw2Marks;
    }

    public Integer getHw3Marks() {
        return hw3Marks;
    }

    public void setHw3Marks(Integer hw3Marks) {
        this.hw3Marks = hw3Marks;
    }

    public Integer getMidtermMarks() {
        return midtermMarks;
    }

    public void setMidtermMarks(Integer midtermMarks) {
        this.midtermMarks = midtermMarks;
    }

    public Integer getProjectMarks() {
        return projectMarks;
    }

    public void setProjectMarks(Integer projectMarks) {
        this.projectMarks = projectMarks;
    }

    public Integer getFinalMarks() {
        return finalMarks;
    }

    public void setFinalMarks(Integer finalMarks) {
        this.finalMarks = finalMarks;
    }

    public Double getFinal_numerical_grade() {
        return final_numerical_grade;
    }

    public void setFinal_numerical_grade(Double final_numerical_grade) {
        this.final_numerical_grade = final_numerical_grade;
    }

    public Double calculateFinalNumericalGrade() {
        Double finalNumericalGrade =
                (0.45 * ((getHw1Marks() + getHw2Marks() + getHw3Marks()) / 3)) +
                (0.25 * getProjectMarks()) +
                (0.30 * (getMidtermMarks() / 2));
        setFinal_numerical_grade(finalNumericalGrade);
        return finalNumericalGrade;
    }

    public String calculateFinalLetterGrade() {
        if (getFinal_numerical_grade() == null) {
            calculateFinalNumericalGrade();
        }
        Double finalNumericalGrade = getFinal_numerical_grade();
        if (finalNumericalGrade >= 90 && finalNumericalGrade <= 100) {
            setFinal_letter_grade("A");
        } else if (finalNumericalGrade >= 80 && finalNumericalGrade <= 89) {
            setFinal_letter_grade("B");
        } else if (finalNumericalGrade >= 70 && finalNumericalGrade <= 79) {
            setFinal_letter_grade("C");
        } else if (finalNumericalGrade >= 60 && finalNumericalGrade <= 69) {
            setFinal_letter_grade("D");
        } else if (finalNumericalGrade >= 0 && finalNumericalGrade <= 59) {
            setFinal_letter_grade("F");
        }
        return getFinal_letter_grade();
    }

    public Student(String name, Integer hw1Marks, Integer hw2Marks, Integer hw3Marks, Integer midtermMarks, Integer projectMarks, Integer finalMarks) {
        this.name = name;
        this.hw1Marks = hw1Marks;
        this.hw2Marks = hw2Marks;
        this.hw3Marks = hw3Marks;
        this.midtermMarks = midtermMarks;
        this.projectMarks = projectMarks;
        this.finalMarks = finalMarks;

//        adding the method to constructor as the constructor checks for the validity of the data and the data type
        calculateFinalLetterGrade();
    }

    public Object[] toArray() {
        List<String> studentList = Arrays.asList(name, final_letter_grade, final_numerical_grade.toString());
        return studentList.toArray();
    }

    @Override
    public String toString() {
        return "Student " +
                "name = '" + name + '\'' +
                ", final_numerical_grade = " + final_numerical_grade +
                ", final_letter_grade = '" + final_letter_grade + '\'' +
//                ", hw1Marks=" + hw1Marks +
//                ", hw2Marks=" + hw2Marks +
//                ", hw3Marks=" + hw3Marks +
//                ", midtermMarks=" + midtermMarks +
//                ", projectMarks=" + projectMarks +
//                ", finalMarks=" + finalMarks +
                ' ';
    }
}
