package Entities;

import java.time.LocalDateTime;
import java.util.List;

public class Student extends User {
    static long lastId = 0;
    private String department;
    private List<Course> enrolledCourses; // Öğrencinin kayıtlı dersleri

    public Student(String username, String password, String department) {
        super(++lastId, username, password, "Student");
        this.department = department;
    }
    // Aynı zamanda Aggregation'ın "has a .." ilişkisini kullanmış olduk



    // Getters and Setters

    public String getDepartment(){ return department; }

    public void setDepartment(String department){ this.department = department; }

    public List<Course> getEnrolledCourses(){ return enrolledCourses; }

    public void setEnrolledCourses(List<Course> enrolledCourses){ this.enrolledCourses = enrolledCourses; }

}
