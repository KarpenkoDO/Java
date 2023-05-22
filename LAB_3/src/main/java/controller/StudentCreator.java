package controller;

import model.Student;
import model.Sex;

public class StudentCreator {
    public Student createStudent(String firstName, String lastName, String middleName, Sex gender, String studentId) {
        return new Student(firstName, lastName, middleName, gender, studentId);
    }
}