package model;
import com.google.gson.Gson;

public class University {
    private String name;
    private Faculty faculty;

    public University(String name, Faculty faculty) {
        this.name = name;
        this.faculty = faculty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public static University fromJson(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, University.class);
    }

    public void addFaculty(Faculty faculty) {
    }
}