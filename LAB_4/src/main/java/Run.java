import model.*;
import controller.*;

import java.util.List;

public class Run {
    public static void main(String[] args) {
        UniversityCreator universityCreator = new UniversityCreator();
        FacultyCreator facultyCreator = new FacultyCreator();
        DepartmentCreator departmentCreator = new DepartmentCreator();
        GroupCreator groupCreator = new GroupCreator();
        StudentCreator studentCreator = new StudentCreator();

        // Створення студентів
        Student student1 = studentCreator.createStudent("John", "Doe", "Smith", Sex.MALE, "12345");
        Student student2 = studentCreator.createStudent("Jane", "Doe", "Smith", Sex.FEMALE, "67890");

        // Створення групи та додавання студентів до неї
        Group group = groupCreator.createGroup("Group 1", List.of(student1, student2));

        // Створення підрозділу та додавання групи до нього
        Department department = departmentCreator.createDepartment("Department 1");
        department.addGroup(group);

        // Створення факультету та додавання підрозділу до нього
        Faculty faculty = facultyCreator.createFaculty("Faculty 1");
        faculty.addDepartment(department);

        // Створення університету та додавання факультету до нього
        University university = universityCreator.createUniversity("University 1", faculty);

        // Виведення даних університету
        System.out.println("University Name: " + university.getName());

        if (university.getFaculty() != null) {
            System.out.println("Faculty Name: " + university.getFaculty().getName());

            if (university.getFaculty().getDepartment() != null) {
                System.out.println("Department Name: " + university.getFaculty().getDepartment().getName());

                if (university.getFaculty().getDepartment().getGroup() != null) {
                    System.out.println("Group Name: " + university.getFaculty().getDepartment().getGroup().getName());
                    System.out.println("Students in the Group:");

                    List<Student> students = university.getFaculty().getDepartment().getGroup().getStudents();
                    if (students != null) {
                        for (Student student : students) {
                            System.out.println("Student Name: " + student.getFirstName() + " " + student.getLastName());
                            System.out.println("Student ID: " + student.getStudentId());
                            System.out.println("Gender: " + student.getGender());
                            System.out.println("-----------------------------");
                        }
                    }
                }
            }
        }
    }
}