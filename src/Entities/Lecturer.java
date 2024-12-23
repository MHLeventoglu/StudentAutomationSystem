package Entities;

import java.time.LocalDateTime;
import java.util.List;

public class Lecturer extends User {
    static long lastId = 0;
    private String faculty;
    private List<Course> courses;

    // Constructor
    public Lecturer(long id, String username, String password,String faculty) {
        super(++lastId, username, password, "Lecturer");
        this.faculty = faculty;
    }


    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}

