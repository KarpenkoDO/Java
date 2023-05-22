package main;

import controller.*;
import model.*;

import java.util.List;

public class Run {
    public static void main(String[] args) {
        UniversityCreator universityCreator = new UniversityCreator();
        FacultyCreator facultyCreator = new FacultyCreator();
        DepartmentCreator departmentCreator = new DepartmentCreator();
        GroupCreator groupCreator = new GroupCreator();
        StudentCreator studentCreator = new StudentCreator();

        // Створення університету
        Student student1 = studentCreator.createStudent("John", "Doe", "Smith", Sex.MALE, "12345");
        Student student2 = studentCreator.createStudent("Jane", "Doe", "Smith", Sex.FEMALE, "67890");
        Group group = groupCreator.createGroup("Group 1", List.of(student1, student2));
        Department department = departmentCreator.createDepartment("Department 1", group);
        Faculty faculty = facultyCreator.createFaculty("Faculty 1", department);
        University university = universityCreator.createUniversity("University 1", faculty);

        // Виведення даних університету
        System.out.println("University Name: " + university.getName());
        System.out.println("Faculty Name: " + university.getFaculty().getName());
        System.out.println("Department Name: " + university.getFaculty().getDepartment().getName());
        System.out.println("Group Name: " + university.getFaculty().getDepartment().getGroup().getName());
        System.out.println("Students in the Group:");
        for (Student student : university.getFaculty().getDepartment().getGroup().getStudents()) {
            System.out.println("Student Name: " + student.getFirstName() + " " + student.getLastName());
            System.out.println("Student ID: " + student.getStudentId());
            System.out.println("Gender: " + student.getGender());
            System.out.println("-----------------------------");
        }
    }
}