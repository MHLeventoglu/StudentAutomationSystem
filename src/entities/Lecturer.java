package entities;

import java.util.ArrayList;
import java.util.List;

public class Lecturer extends User {
    static long lastId = 0;
    private String faculty;
    private List<Course> courses = new ArrayList<>();

    // Constructor
    public Lecturer(String username, String password,String faculty,String mail) {
        super(++lastId, username, password, "Öğretim Görevlisi",mail);
        this.faculty = faculty;
    }
    public Lecturer(long id, String username, String password,String faculty,String mail) {
        super(id, username, password, "Öğretim Görevlisi",mail);
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

    public void addCourse(Course course){this.courses.add(course);}

    public void removeCourse(String courseCode){
        courses.removeIf(c -> c.getCourseCode() == courseCode);
    }

    @Override
    public String toString(){
        return "ID: "+this.getId()+" / İsim: "+this.getName();
    }
}

