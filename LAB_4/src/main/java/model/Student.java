package model;

public class Student extends Human {
    private String studentId;

    public Student(String firstName, String lastName, String middleName, Sex gender, String studentId) {
        super(firstName, lastName, middleName, gender);
        this.studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
}