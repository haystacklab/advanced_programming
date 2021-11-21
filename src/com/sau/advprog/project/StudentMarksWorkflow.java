package com.sau.advprog.project;

import com.sau.advprog.project.model.LetterGrades;
import com.sau.advprog.project.model.Student;
import com.sau.advprog.project.model.StudentMarksWorkflowWrapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentMarksWorkflow {

    List<Student> studentMarks = new ArrayList();
    List<String> studentData = new ArrayList();
    List<String> badData = new ArrayList();
    String fileLocation = "src/com/sau/advprog/project/student_grades_input.txt";
    LetterGrades letterGrades = new LetterGrades();

    StudentMarksWorkflow(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    protected StudentMarksWorkflowWrapper runStudentMarksWorkflow() {
        getStudentData();
        getStudentMarks();

        StudentMarksWorkflowWrapper studentMarksWorkflowWrapper =
                new StudentMarksWorkflowWrapper(studentMarks, badData, letterGrades);

        return studentMarksWorkflowWrapper;
    }

    private void getStudentData() {
        ReadFile readFile = new ReadFile();
        try {
            studentData = readFile.readFile(fileLocation);
        } catch (Exception e) {
            System.out.println("Could not read given file. Read file failed with exception: " + e);
        }
    }

    private void getStudentMarks() {
        //        checking if reading file went well by checking the length of the marks array
        if (studentData.size() > 0) {
            for (String student: studentData) {
                sanitizeStudentDataAndAddToMarks(student);
            }
        }
    }

    private void sanitizeStudentDataAndAddToMarks(String student) {
        String[] splitStudentItems = student.split(",");
        if (splitStudentItems[0].equals("Name")) {
//            header
            return;
        }
        if (splitStudentItems.length == 7) {
//                    all data is present good to go
            String studentName = splitStudentItems[0];
            Integer homework1Marks = Integer.parseInt(splitStudentItems[1].trim());
            Integer homework2Marks = Integer.parseInt(splitStudentItems[2].trim());
            Integer homework3Marks = Integer.parseInt(splitStudentItems[3].trim());
            Integer homework4Marks = Integer.parseInt(splitStudentItems[4].trim());
            Integer homework5Marks = Integer.parseInt(splitStudentItems[5].trim());
            Integer homework6Marks = Integer.parseInt(splitStudentItems[6].trim());
            try {
//              data type check; if exception is thrown here, data is no good to continue, add it to bad ones
                Student newStudent = new Student(studentName, homework1Marks, homework2Marks, homework3Marks,
                        homework4Marks, homework5Marks, homework6Marks);
                letterGrades.incrementGradeCount(newStudent.getFinal_letter_grade());
                studentMarks.add(newStudent);
            } catch (Exception e) {
                // add to bad ones
                System.out.println("Data parsing failed for student: " + splitStudentItems[1] + ", with " +
                        "exception: " + e);
                badData.add(student);
            }
        } else {
            // add to bad ones
            System.out.println("Data incomplete for student: " + splitStudentItems[1]);
            badData.add(student);
        }
    }

}
