/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.classroster.ui;

import com.sg.classroster.dto.Student;
import java.util.List;

/**
 *
 * @author n0200797
 */
public class ClassRosterView {

    //UserIO io = new UserIOConsoleImpl();
    private UserIO io;

///////////////    /////////////////////////////////////////////
    public ClassRosterView(UserIO io) {
        this.io = io;
    }
////////////////////////////////////////////////////////////////////

    public int printMenuAndGetSelection() {
        io.print("MAIN MENU");
        io.print("1. Liste Student IDs");
        io.print("2. Create New Student");
        io.print("3. View Student");
        io.print("4. Remove a Student");
        io.print("5. Exit");

        return io.readInt("Please select from the above choices.", 1, 5);
    }

    public void displayCreateStudentBanner() {
        io.print("===CREATE STUDENT===");

    }

    public Student getNewStudentInfo() {
        String studentId = io.readString("Please Enter a Student ID");
        String firstNmae = io.readString("Please Enter First Name");
        String lastName = io.readString("Please Enter Last Name");
        String cohort = io.readString("Please Enter Cohort");

        Student currentStudent = new Student(studentId);
        currentStudent.setFirstName(firstNmae);
        currentStudent.setLastName(lastName);
        currentStudent.setCohort(cohort);

        return currentStudent;
    }

    public void displayCreateSuccessBanner() {
        io.readString("STUDENT SUCCESSFULLY CREATED. PLEASE HIT ENTER TO CONTINUE");
    }

    //Method 
    public void displayStudentList(List<Student> studentList) {
        for (Student currentStudent : studentList) {
            io.print(currentStudent.getStudentId() + " :"
                    + currentStudent.getFirstName() + " :"
                    + currentStudent.getLastName());
        }

    }

    public void displayDisplayAllBanner() {
        io.print("=== DISPLAY ALL STUDENTS===");
    }

//Method    
    public void displayDisplayStudentBanner() {
        io.print("=== Display Student ===");

    }

    public String getStudentIdChoice() {
        return io.readString("Please enter the Student ID.");
    }

    public void displayStudent(Student student) {
        if (student != null) {
            io.print(student.getStudentId());
            io.print(student.getFirstName() + " " + student.getLastName());
            io.print(student.getCohort());
            io.print("");
        } else {
            io.print("No such student.");
        }
        io.readString("Please hit enter to continue.");

    }
//Method to Remove  a student

    public void displayRemoveStudentBanner() {
        io.print("=== Remove Student ===");
    }

    public void displayRemoveSuccessBanner() {
        io.readString("Student successfully removed. Please hit enter to continue.");
    }
//Method For Unknown

    public void displayExitBanner() {
        io.print("GOOD BYE!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

//Method To display Given ERROR ----------------
    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
}
