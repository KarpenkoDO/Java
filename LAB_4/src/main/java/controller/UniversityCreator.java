package controller;

import model.University;
import model.Faculty;

public class UniversityCreator {
    public University createUniversity(String name, Faculty faculty) {
        return new University(name, faculty);
    }
}