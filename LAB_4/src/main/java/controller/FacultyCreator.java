package controller;

import model.Faculty;
import model.Department;

public class FacultyCreator {

    public Faculty createFaculty(String facultyName) {
        Faculty faculty = new Faculty(facultyName);
        return faculty;
    }

    public Faculty createFaculty(String facultyName, Department department) {
        Faculty faculty = new Faculty(facultyName);
        faculty.addDepartment(department);
        return faculty;
    }
}