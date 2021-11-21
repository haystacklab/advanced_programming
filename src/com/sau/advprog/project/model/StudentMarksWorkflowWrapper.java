package com.sau.advprog.project.model;

import java.util.List;

public class StudentMarksWorkflowWrapper {
    List<Student> studentMarks;

    List<String> badData;

    LetterGrades letterGrades;

    public List<Student> getStudentMarks() {
        return studentMarks;
    }

    public void setStudentMarks(List<Student> studentMarks) {
        this.studentMarks = studentMarks;
    }

    public List<String> getBadData() {
        return badData;
    }

    public void setBadData(List<String> badData) {
        this.badData = badData;
    }

    public LetterGrades getLetterGrades() {
        return letterGrades;
    }

    public void setLetterGrades(LetterGrades letterGrades) {
        this.letterGrades = letterGrades;
    }

    public StudentMarksWorkflowWrapper(List<Student> studentMarks, List<String> badData, LetterGrades letterGrades) {
        this.studentMarks = studentMarks;
        this.badData = badData;
        this.letterGrades = letterGrades;
    }
}
