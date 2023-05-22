package controller;

import model.Department;
import model.Group;

public class DepartmentCreator {

    public Department createDepartment(String departmentName) {
        Department department = new Department(departmentName);
        return department;
    }

    public Department createDepartment(String departmentName, Group group) {
        Department department = new Department(departmentName);
        department.addGroup(group);
        return department;
    }
}