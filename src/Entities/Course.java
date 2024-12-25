package Entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Course extends BaseEntity {
    static long lastId = 0;
    private String courseCode;
    private String courseName;
    private int credit;
    private Lecturer instructor;
    private List<Student> students;

    public Course(String courseCode) {
        super(++lastId);
        this.courseCode = courseCode;
        students = new ArrayList<Student>();
    }

    // Getters and Setters

    public void setCourseCode(String courseCode) {this.courseCode = courseCode;}

    public String getCourseCode() {return courseCode;}

    public String getCourseName() {return courseName;}

    public void setCourseName(String courseName) {this.courseName = courseName;}

    public int getCredit() {return credit;}

    public void setCredit(int credit) {this.credit = credit;}

    public Lecturer getInstructor() {return instructor;}

    public void setInstructor(Lecturer instructor) {this.instructor = instructor;}

    public List<Student> getStudents() {return students;}

    public void addStudent(Student student) {this.students.add(student);}

    public void removeStudent(Student student){this.students.remove(student);}
}

