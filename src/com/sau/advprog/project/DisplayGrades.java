package com.sau.advprog.project;

import com.sau.advprog.project.model.LetterGrades;
import com.sau.advprog.project.model.Student;
import com.sau.advprog.project.model.StudentMarksWorkflowWrapper;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DisplayGrades {

    List<Student> studentMarks;
    LetterGrades letterGrades;

    protected void displayData() {
        Object[][] studentsArray = getStudentsArray();
        Object[][] letterGradesArray = getLetterGradesArray();


        generateJFrame(studentsArray, letterGradesArray);
    }

    private void generateJFrame(Object[][] studentMarksData, Object[][] letterGradesCount) {
        final JFrame frame = new JFrame("Student Grades Data");

        String[] columns = {"Student Name", "Final Letter Grade", "Final numerical grade"};
        String[] columns2 = {"Grade", "Count"};


        JLabel lblHeading = new JLabel("Student Grades");
        lblHeading.setFont(new Font("Arial",Font.TRUETYPE_FONT,20));

        JLabel lblHeading2 = new JLabel("Grades count", SwingConstants.CENTER);
        lblHeading2.setFont(new Font("Arial",Font.TRUETYPE_FONT,24));


        JTable table = new JTable(studentMarksData, columns);
        JTable table2 = new JTable(letterGradesCount, columns2);

        Container pane = new JPanel();
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
        table.setAlignmentX(Component.CENTER_ALIGNMENT);
        table2.setAlignmentX(Component.CENTER_ALIGNMENT);
        pane.add(lblHeading);
        pane.add(table.getTableHeader());
        pane.add(table);
        pane.add(Box.createVerticalStrut(10));
        pane.add(lblHeading2);
        pane.add(table2.getTableHeader());
        pane.add(table2);

        JScrollPane scrollPane = new JScrollPane(pane);

        frame.add(scrollPane,BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setVisible(true);
    }

    private Object[][] getStudentsArray() {
        Object[][] studentsArray = new String[studentMarks.size()][3];
        List<Object[]> studentDataList = new ArrayList();
        for (Student student: studentMarks) {
            studentDataList.add(student.toArray());
        }
        studentsArray = studentDataList.toArray(new Object[0][]);
        return studentsArray;
    }

    private Object[][] getLetterGradesArray() {
        List<Object[]> letterGradesDataList = new ArrayList();
        List<String> grades = Arrays.asList("A", "B", "C", "D", "F");

        for (int i = 0; i < 5; i++) {
            letterGradesDataList.add(new Object[]{grades.get(i), letterGrades.toArray()[i]});
        }

        Object[][] letterGradesArray = letterGradesDataList.toArray(new Object[0][]);
        return letterGradesArray;
    }

    public DisplayGrades(StudentMarksWorkflowWrapper studentMarksWorkflowWrapper) {
        studentMarks = studentMarksWorkflowWrapper.getStudentMarks();
        letterGrades = studentMarksWorkflowWrapper.getLetterGrades();
    }

    public List<Student> getStudentData() {
        return studentMarks;
    }

    public void setStudentData(List<Student> studentMarks) {
        this.studentMarks = studentMarks;
    }

    public LetterGrades getLetterGrades() {
        return letterGrades;
    }

    public void setLetterGrades(LetterGrades letterGrades) {
        this.letterGrades = letterGrades;
    }
}
