package com.sau.advprog.project.model;

import java.util.Arrays;
import java.util.List;

public class LetterGrades {
    private Integer A = 0;
    private Integer B = 0;
    private Integer C = 0;
    private Integer D = 0;
    private Integer F = 0;

    public void incrementGradeCount(String grade) {
        switch (grade) {
            case "A":
                A++;
                break;
            case "B":
                B++;
                break;
            case "C":
                C++;
                break;
            case "D":
                D++;
                break;
            case "F":
                F++;
                break;
            default:
                System.out.println("not a valid grade: " + grade);
        }
    }

    @Override
    public String toString() {
        return "LetterGrades: " +
                "A= " + A +
                ", B= " + B +
                ", C= " + C +
                ", D= " + D +
                ", F= " + F;
    }

    public Object[] toArray() {
        List<String> studentList = Arrays.asList(A.toString(), B.toString(), C.toString(), D.toString(), F.toString());
        return studentList.toArray();
    }
}
