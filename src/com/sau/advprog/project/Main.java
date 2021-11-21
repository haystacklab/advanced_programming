package com.sau.advprog.project;

import com.sau.advprog.project.model.StudentMarksWorkflowWrapper;

public class Main {
    public static void main(String args[]) {
        String fileLocation = "src/com/sau/advprog/project/student_grades_input.txt";
        StudentMarksWorkflow studentMarksWorkflow = new StudentMarksWorkflow(fileLocation);
        StudentMarksWorkflowWrapper studentDataWrapper = studentMarksWorkflow.runStudentMarksWorkflow();

        DisplayGrades displayGrades = new DisplayGrades(studentDataWrapper);
        displayGrades.displayData();
    }
}
