package controller;

import model.Faculty;
import model.Department;

public class FacultyCreator {
    public Faculty createFaculty(String name, Department department) {
        return new Faculty(name, department);
    }
}