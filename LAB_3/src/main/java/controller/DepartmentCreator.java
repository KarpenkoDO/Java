package controller;

import model.Department;
import model.Group;

public class DepartmentCreator {
    public Department createDepartment(String name, Group group) {
        return new Department(name, group);
    }
}