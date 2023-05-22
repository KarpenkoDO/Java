package controller;

import model.Faculty;
import model.University;

public class UniversityCreator {
    public University createUniversity(String name, Faculty faculty) {
        return new University(name, faculty);
    }
}