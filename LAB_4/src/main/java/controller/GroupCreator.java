package controller;

import model.Group;
import model.Student;

import java.util.List;

public class GroupCreator {
    public Group createGroup(String name, List<Student> students) {
        return new Group(name, students);
    }
}